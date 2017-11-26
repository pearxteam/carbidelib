package ru.pearx.lib;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/*
 * Created by mrAppleXZ on 26.11.17 11:13.
 */
public class MultipartBuilder
{
    //todo text
    private String boundary;
    private OutputStream out;
    private String separator;
    private PrintWriter pw;

    public MultipartBuilder(OutputStream out, String boundary)
    {
        this.out = out;
        this.boundary = boundary;
        this.separator = "--" + boundary;
        this.pw = new PrintWriter(out);
    }

    public MultipartBuilder appendBinary(String name, InputStream stream, String filename, String mimeType) throws IOException
    {
        pw.append(separator).append("\r\n");
        pw.append("Content-Disposition: form-data; name=\"").append(name).append("\"; filename=\"").append(filename).append("\"\r\n");
        pw.append("Content-Type: ").append(mimeType).append("\r\n");
        pw.append("\r\n");
        pw.flush();
        PXL.writeStream(stream, out);
        out.flush();
        pw.append("\r\n");
        pw.flush();
        return this;
    }

    public MultipartBuilder end()
    {
        pw.append(separator).append("--\r\n");
        pw.flush();
        return this;
    }
}
