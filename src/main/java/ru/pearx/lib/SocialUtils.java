package ru.pearx.lib;

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
        sb.append("url=").append(PXL.encodeUrl(url));
        if(title != null)
            sb.append("&title=").append(PXL.encodeUrl(title));
        if(description != null)
            sb.append("&description=").append(PXL.encodeUrl(description));
        if(img_url != null)
            sb.append("&image=").append(PXL.encodeUrl(img_url));
        PXL.openUrl(sb.toString());
    }

    /**
     * Shares a text using Twitter.
     * @param text Tweet text.
     */
    public static void tweet(String text)
    {
        PXL.openUrl("https://twitter.com/intent/tweet?text=" + PXL.encodeUrl(text));
    }
}
