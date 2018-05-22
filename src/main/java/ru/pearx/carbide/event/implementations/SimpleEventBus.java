/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.event.implementations;

import ru.pearx.carbide.event.EventBody;
import ru.pearx.carbide.event.EventBus;
import ru.pearx.carbide.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by mrAppleXZ on 20.05.18 13:21.
 */
public class SimpleEventBus implements EventBus
{
    private Map<EventType, List<EventBody>> events = new HashMap<>();

    public <T> void invoke(EventType<T> type, T args)
    {
        List<EventBody> lst = events.get(type);
        if (lst != null)
        {
            for (EventBody bod : lst)
            {
                bod.invoke(args);
            }
        }
    }

    public <T> void subscribe(EventType<T> type, EventBody<T> body)
    {
        List<EventBody> lst = events.computeIfAbsent(type, k -> new ArrayList<>());
        lst.add(body);
    }
}
