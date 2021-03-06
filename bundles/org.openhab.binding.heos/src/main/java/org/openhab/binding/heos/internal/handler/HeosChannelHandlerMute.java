/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.heos.internal.handler;

import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.types.RefreshType;
import org.openhab.binding.heos.handler.HeosBridgeHandler;
import org.openhab.binding.heos.internal.api.HeosFacade;

/**
 * The {@link HeosChannelHandlerMute} handles the Mute channel command
 * from the implementing thing.
 *
 * @author Johannes Einig - Initial contribution
 *
 */
public class HeosChannelHandlerMute extends HeosChannelHandler {

    public HeosChannelHandlerMute(HeosBridgeHandler bridge, HeosFacade api) {
        super(bridge, api);
    }

    @Override
    protected void handleCommandPlayer() {
        if (command instanceof RefreshType) {
            api.getHeosPlayerMuteState(id);
            return;
        }
        if (command.equals(OnOffType.ON)) {
            api.muteON(id);
        } else if (command.equals(OnOffType.OFF)) {
            api.muteOFF(id);
        }
    }

    @Override
    protected void handleCommandGroup() {
        if (command instanceof RefreshType) {
            api.getHeosGroupeMuteState(id);
            return;
        }
        if (command.equals(OnOffType.ON)) {
            api.muteGroupON(id);
        } else if (command.equals(OnOffType.OFF)) {
            api.muteGroupOFF(id);
        }
    }

    @Override
    protected void handleCommandBridge() {
        // No such channel on bridge
    }
}
