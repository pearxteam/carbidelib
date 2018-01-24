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

/**
 * An URI builder.
 * @see <a href="https://en.wikipedia.org/wiki/Uniform_Resource_Identifier"></a>
 */
public class URIBuilder
{
    private String scheme;
    private String host;
    private int port;
    private String path;
    private Map<String, String> query = new HashMap<>();
    private String fragment;

    /**
     * Creates a builder using the specified URI.
     * @param in URI.
     */
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

    /**
     * Sets the scheme.
     * @param scheme The scheme. "http", for instance.
     */
    public URIBuilder setScheme(String scheme)
    {
        this.scheme = scheme;
        return this;
    }

    /**
     * Sets the host.
     * @param host The host. "google.com", for instance.
     */
    public URIBuilder setHost(String host)
    {
        this.host = host;
        return this;
    }

    /**
     * Sets the port.
     * @param port The port. "80", for instance.
     */
    public URIBuilder setPort(int port)
    {
        this.port = port;
        return this;
    }

    /**
     * Sets the path.
     * @param path The path. "/img/main.jpg" or "pics/face.png", for instance.
     * @return
     */
    public URIBuilder setPath(String path)
    {
        this.path = path;
        return this;
    }

    /**
     * Sets the fragment.
     * @param fragment The fragment. "about", for example.
     */
    public URIBuilder setFragment(String fragment)
    {
        this.fragment = fragment;
        return this;
    }

    /**
     * Puts a query entry.
     * @param key A key. It will be automatically encoded in the {@link #buildQuery()}.
     * @param val A value. It will be automatically encoded in the {@link #buildQuery()}.
     */
    public URIBuilder putQuery(String key, String val)
    {
        query.put(key, val);
        return this;
    }

    /**
     * Removes a query entry with the specified key.
     * @param key A key.
     */
    public URIBuilder removeQuery(String key)
    {
        query.remove(key);
        return this;
    }

    /**
     * Clears the query.
     */
    public URIBuilder clearQuery()
    {
        query.clear();
        return this;
    }

    /**
     * Gets a query entry with the specified key.
     * @param key A key.
     */
    public String getQuery(String key)
    {
        return query.get(key);
    }

    /**
     * Gets the scheme.
     */
    public String getScheme()
    {
        return scheme;
    }

    /**
     * Gets the host.
     */
    public String getHost()
    {
        return host;
    }

    /**
     * Gets the port.
     */
    public int getPort()
    {
        return port;
    }

    /**
     * Gets the path.
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Gets the fragment.
     */
    public String getFragment()
    {
        return fragment;
    }

    /**
     * Builds the {@link URI} using the {@link #toString()} method.
     * @throws URISyntaxException If the URI is malformed.
     */
    public URI buildUri() throws URISyntaxException
    {
        return new URI(toString());
    }

    /**
     * Builds the {@link URL} using the {@link #toString()} method.
     * @throws MalformedURLException If the URL is malformed.
     */
    public URL buildUrl() throws MalformedURLException
    {
        return new URL(toString());
    }

    /**
     * Creates a string presentation of the URI. Format: scheme://host:port/path?query#fragment.
     */
    @Override
    public String toString()
    {
        return getScheme() + "://" + getHost() + (getPort() == -1 ? "" : ":" + getPort()) + (getPath().startsWith("/") ? "" : "/") + getPath() + "?" + buildQuery() + (PXL.isNullOrEmpty(getFragment()) ? "" : "#" + getFragment());
    }

    /**
     * Builds the query.
     */
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
