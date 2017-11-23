package ru.pearx.lib;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by mrAppleXZ on 21.11.17 16:38.
 */
public class URIBuilder
{
    private String scheme;
    private String host;
    private int port;
    private String path;
    private Map<String, String> query = new HashMap<>();
    private String fragment;

    public URIBuilder(String in)
    {
        URI uri = URI.create(in);
        setScheme(uri.getScheme());
        setHost(uri.getHost());
        setPort(uri.getPort());
        setPath(uri.getPath());
        if(uri.getRawQuery() != null)
        {
            String[] q = uri.getRawQuery().split("&");
            for (String s : q)
            {
                String[] dat = s.split("=");
                putQuery(PXL.decodeUrl(dat[0]), PXL.decodeUrl(dat[1]));
            }
        }
    }

    public URIBuilder setScheme(String scheme)
    {
        this.scheme = scheme;
        return this;
    }

    public URIBuilder setHost(String host)
    {
        this.host = host;
        return this;
    }

    public URIBuilder setPort(int port)
    {
        this.port = port;
        return this;
    }

    public URIBuilder setPath(String path)
    {
        this.path = path;
        return this;
    }

    public URIBuilder setFragment(String fragment)
    {
        this.fragment = fragment;
        return this;
    }

    public URIBuilder putQuery(String key, String val)
    {
        query.put(key, val);
        return this;
    }

    public URIBuilder removeQuery(String key)
    {
        query.remove(key);
        return this;
    }

    public URIBuilder clearQuery()
    {
        query.clear();
        return this;
    }

    public String getQuery(String key)
    {
        return query.get(key);
    }

    public String getScheme()
    {
        return scheme;
    }

    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    public String getPath()
    {
        return path;
    }

    public String getFragment()
    {
        return fragment;
    }

    public URI buildUri() throws URISyntaxException
    {
        return new URI(toString());
    }

    public URL buildUrl() throws MalformedURLException
    {
        return new URL(toString());
    }

    @Override
    public String toString()
    {
        return getScheme() + "://" + getHost() + (getPort() == -1 ? "" : ":" + getPort()) + (getPath().startsWith("/") ? "" : "/") + getPath() + "?" + buildQuery() + (PXL.isNullOrEmpty(getFragment()) ? "" : "#" + getFragment());
    }

    private String buildQuery()
    {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entr : query.entrySet())
        {
            sb.append(PXL.encodeUrl(entr.getKey()));
            sb.append("=");
            sb.append(PXL.encodeUrl(entr.getValue()));
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
