package ru.pearx.lib;

import com.sun.istack.internal.Nullable;

/*
 * Created by mrAppleXZ on 04.07.17 14:43.
 */
public class SocialUtils
{
    public static void shareVK(String url, @Nullable String title, @Nullable String description, @Nullable String img_url)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("https://vk.com/share.php?");
        sb.append("url=").append(PXL.encodeUrl(url));
        if(title != null)
            sb.append("&title=").append(PXL.encodeUrl(title));
        if(description != null)
            sb.append("&description=").append(PXL.encodeUrl(description));
        if(img_url != null)
            sb.append("&image=").append(PXL.encodeUrl(img_url));
        PXL.openUrl(sb.toString());
    }

    public static void tweet(String text)
    {
        PXL.openUrl("https://twitter.com/intent/tweet?text=" + PXL.encodeUrl(text));
    }
}
