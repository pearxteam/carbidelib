/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.event;

/*
 * Created by mrAppleXZ on 22.05.18 10:14.
 */
public interface EventBus
{
    <T> void invoke(EventType<T> type, T args);
    <T> void subscribe(EventType<T> type, EventBody<T> body);
}
