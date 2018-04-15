/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide;

/*
 * Created by mrAppleXZ on 04.07.17 14:43.
 */
public class SocialUtils
{
    /**
     * Shares a URL using VK.
     * @param url URL.
     * @param title Title. Nullable.
     * @param description Description. Nullable.
     * @param img_url Image URL.
     */
    public static void shareVK(String url, String title, String description, String img_url)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("https://vk.com/share.php?");
        sb.append("url=").append(StringUtils.encodeUrl(url));
        if(title != null)
            sb.append("&title=").append(StringUtils.encodeUrl(title));
        if(description != null)
            sb.append("&description=").append(StringUtils.encodeUrl(description));
        if(img_url != null)
            sb.append("&image=").append(StringUtils.encodeUrl(img_url));
        OtherUtils.openUrl(sb.toString());
    }

    /**
     * Shares a text using Twitter.
     * @param text Tweet text.
     */
    public static void tweet(String text)
    {
        OtherUtils.openUrl("https://twitter.com/intent/tweet?text=" + StringUtils.encodeUrl(text));
    }
}
