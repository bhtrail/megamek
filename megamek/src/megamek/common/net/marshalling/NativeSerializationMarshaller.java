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
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_MOVE, EntityMovePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_DEPLOY, EntityDeployPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_DEPLOY_UNLOAD, EntityDeployUnloadPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SERVER_ENTITY_ATTACK, ServerEntityAttackPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CLIENT_ENTITY_ATTACK, ClientEntityAttackPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_PREPHASE, EntityPrephasePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_GTA_HEX_SELECT, EntityGTAHexSelectPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SERVER_ENTITY_UPDATE, ServerEntityAttackPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CLIENT_ENTITY_UPDATE, ClientEntityUpdatePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_MULTIUPDATE, EntityMultiUpdatePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_WORDER_UPDATE, EntityWOrderPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_ASSIGN, EntityAssignPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_MODECHANGE, EntityModeChangePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_AMMOCHANGE, EntityAmmoChangePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_SENSORCHANGE, EntitySensorChangePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_SINKSCHANGE, EntitySinksChangePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_ACTIVATE_HIDDEN, EntityActivateHiddenPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_SYSTEMMODECHANGE, EntitySystemModeChangePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.FORCE_UPDATE, ForceUpdatePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.FORCE_ADD, ForceAddPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.FORCE_DELETE, ForceDeletePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.FORCE_PARENT, ForceParentPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.FORCE_ADD_ENTITY, ForceAddEntityPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.FORCE_ASSIGN_FULL, ForceAssignFullPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ENTITY_VISIBILITY_INDICATOR, EntityVisibilityIndicatorPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ADD_SMOKE_CLOUD, AddSmokeCloudPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CHANGE_HEX, ChangeHexPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.CHANGE_HEXES, ChangeHexesPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.BLDG_UPDATE, BldgUpdatePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.BLDG_COLLAPSE, BldgCollapsePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.BLDG_EXPLODE, BldgExplodePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.PHASE_CHANGE, PhaseChangePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.TURN, TurnPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.ROUND_UPDATE, RoundUpdatePacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SENDING_BOARD, SendingBoardsPacket.class);
        LOOKUP_PACKETS.put(PacketCommand.SENDING_ILLUM_HEXES, SendingIllumHexesPacket.class);
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
