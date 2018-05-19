/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/*
 * Created by mrAppleXZ on 26.11.17 11:13.
 */

/**
 * Builder for the MIME multipart message.
 * @see <a href="https://en.wikipedia.org/wiki/MIME#Multipart_messages">Wikipedia page</a>
 */
public class MultipartBuilder
{
    //todo text
    private String boundary;
    private OutputStream out;
    private String separator;
    private PrintWriter pw;

    /**
     * Creates a new {@link MultipartBuilder} instance.
     * @param out An {@link OutputStream}, where the data will output.
     * @param boundary A separator between the entries without "--". For instance, "nmfd8HNqgnlp".
     */
    public MultipartBuilder(OutputStream out, String boundary)
    {
        this.out = out;
        this.boundary = boundary;
        this.separator = "--" + boundary;
        this.pw = new PrintWriter(out);
    }

    /**
     * Appends a binary data to the stream.
     * @param name The name of the controlling element.
     * @param stream An {@link InputStream} from which the data will be copied.
     * @param filename The filename.
     * @param mimeType The MIME type.
     * @throws IOException If an error occurs while working with the streams.
     */
    public MultipartBuilder appendBinary(String name, InputStream stream, String filename, String mimeType) throws IOException
    {
        pw.append(separator).append("\r\n");
        pw.append("Content-Disposition: form-data; name=\"").append(name).append("\"; filename=\"").append(filename).append("\"\r\n");
        pw.append("Content-Type: ").append(mimeType).append("\r\n");
        pw.append("\r\n");
        pw.flush();
        OtherUtils.writeStream(stream, out);
        out.flush();
        pw.append("\r\n");
        pw.flush();
        return this;
    }

    /**
     * Ends the multipart entity and flushes the {@link OutputStream}.
     */
    public MultipartBuilder end()
    {
        pw.append(separator).append("--\r\n");
        pw.flush();
        return this;
    }
}
