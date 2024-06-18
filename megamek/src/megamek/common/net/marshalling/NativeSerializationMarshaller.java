/*
 * MegaMek - Copyright (C) 2005 Ben Mazur (bmazur@sev.org)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */
package megamek.common.net.marshalling;

import megamek.MMConstants;
import megamek.common.net.packets.*;
import megamek.common.net.enums.PacketCommand;
import org.nibblesec.tools.SerialKiller;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.Hashtable;

/**
 * Marshaller that Java native serialization for <code>Packet</code> representation.
 */
class NativeSerializationMarshaller extends PacketMarshaller {
    protected static final PacketCommand[] PACKET_COMMANDS = PacketCommand.values();
    protected static final Hashtable<PacketCommand, Class<?>> LOOKUP_PACKETS;
    
    static {
        LOOKUP_PACKETS = new Hashtable<>();
        LOOKUP_PACKETS.put(PacketCommand.CHAT, ChatPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CLIENT_NAME, ClientNamePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CLIENT_VERSIONS, ClientVersionsPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CLOSE_CONNECTION, CloseConnectionPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ILLEGAL_CLIENT_VERSION, IllegalClientVersionPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.LOAD_SAVEGAME, LoadSavedGamePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.LOCAL_PN, LocalPlayerIDPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.PLAYER_ADD, PlayerAddPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.PLAYER_UPDATE, PlayerUpdatePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SERVER_CORRECT_NAME, ServerCorrectNamePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SERVER_GREETING, ServerGreetingPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SERVER_VERSION_CHECK, ServerVersionCheckPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.FORWARD_INITIATIVE, ForwardInitiativePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.PLAYER_REMOVE, PlayerRemovePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.PLAYER_TEAM_CHANGE, PlayerTeamChangePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SERVER_PRINCESS_SETTINGS, ServerPrincessSettingsPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CLIENT_PRINCESS_SETTINGS, ClientPrincessSettingsPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SERVER_PLAYER_READY, ServerPlayerReadyPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CLIENT_PLAYER_READY, ClientPlayerReadyPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_ADD, EntityAddPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_REMOVE, EntityRemovePacket.class);
    }

    @Override
    public void marshall(final AbstractPacket packet, final OutputStream stream) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(stream);
        out.writeInt(packet.getCommand().ordinal());
        out.writeObject(packet.getData());
        out.flush();
    }

    @Override
    public AbstractPacket unmarshall(final InputStream stream) throws Exception {
        final ObjectInputStream in = new SerialKiller(stream, MMConstants.SERIALKILLER_CONFIG_FILE);
        final int command = in.readInt();
        final Object[] args = (Object[]) in.readObject();
        Constructor<?> constructor = LOOKUP_PACKETS.get(PACKET_COMMANDS[command]).getDeclaredConstructor(PacketCommand.class, Object[].class);
        return (AbstractPacket) constructor.newInstance(PACKET_COMMANDS[command], args);
    }
}
