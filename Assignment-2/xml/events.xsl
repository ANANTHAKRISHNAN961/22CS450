<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Events Booking</title>
                <style>
                    /* CSS styles */
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f0f0f0;
                        padding: 20px;
                    }
                    h1 {
                        color: #333;
                    }
                    p {
                        color: #666;
                    }
                    table {
                        border-collapse: collapse;
                        width: 100%;
                        margin-bottom: 20px;
                    }
                    th, td {
                        border: 1px solid #ddd;
                        padding: 8px;
                        text-align: left;
                    }
                    th {
                        background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h1>Events Booking</h1>
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Date</th>
                        <th>Location</th>
                        <th>Description</th>
                        <th>Organizer</th>
                        <th>Availability</th>
                        <th>Price</th>
                        <th>Capacity</th>
                    </tr>
                    <xsl:for-each select="events/event">
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="date"/></td>
                            <td><xsl:value-of select="location"/></td>
                            <td><xsl:value-of select="description"/></td>
                            <td><xsl:value-of select="organizer"/></td>
                            <td><xsl:value-of select="booking/availability"/></td>
                            <td><xsl:value-of select="booking/price"/></td>
                            <td><xsl:value-of select="booking/capacity"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
