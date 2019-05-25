<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:template match="zoo">
    <html>
      <body>
        <table>
          <tr>
            <td>
              <b>
                <xsl:text>Ilosc Zwierzat z Azji: </xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select="count(zwierzeta/Azja/zwierze)"/>
            </td>
          </tr>

          <tr>
            <td>
              <b>
                <xsl:text>Ilosc Zwierzat z Europy: </xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select="count(zwierzeta/Europa/zwierze)"/>
            </td>
          </tr>

          <tr>
            <td>
              <b>
                <xsl:text>Ilosc Kobiet w Polnocnej Ameryce: </xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select="count(zwierzeta/Polnocna_Ameryka/zwierze[@plec='Kobieta'])"/>
            </td>
          </tr>

          <tr>
            <td>
              <b>
                <xsl:text>Ilosc zwierzat lzejszych niz 30 kg pochodzacych z Antarktyki: </xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select="count(zwierzeta/Antarktyka/zwierze[waga &lt;=30])"/>
            </td>
          </tr>

          <tr>
            <td>
              <b>
                <xsl:text>Średnia wieku zwierzat o plci meskiej, pochodzacych z poludniowej ameryki: </xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select="( sum(zwierzeta/Poludniowa_Ameryka/zwierze[@plec='Mezczyzna']/wiek/text()) div count(zwierzeta/Poludniowa_Ameryka/zwierze[@plec='Mezczyzna']))"/>
            </td>
          </tr>
          
            <tr>
            <td>
              <b>
                <xsl:text>Zwiereze ktore znajduje sie przed Rysiem </xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select="zwierzeta/Australia/zwierze[@rasa='Rys']/preceding-sibling::zwierze[1]/imie/text()"/>
            </td>
          </tr>
          
            <tr>
            <td>
              <b>
                <xsl:text>Dlugosc imienia Pandy i Rysia </xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select=" string-length(zwierzeta/Australia/zwierze[@rasa='Rys']/imie) + string-length(zwierzeta/Australia/zwierze[@rasa='Panda']/imie)"/>
            </td>
          </tr>
          
        <tr>
            <td>
              <b>
                <xsl:text>Ilosc zwierzat ktore zaczynaja sie na T z Polnocnej Ameryki</xsl:text>
              </b>
            </td>
            <td>
              <xsl:value-of select="  count(zwierzeta/Polnocna_Ameryka/zwierze[starts-with(imie, 'T')])"/>
            </td>
          </tr>
        
        </table>
        
        <h2>Afryka</h2>
        <table>
          <xsl:for-each select="zwierzeta/Afryka/zwierze">
            <xsl:sort select="imie" order="ascending"/>
            <xsl:if test="gromada='Ssaki'">
              <xsl:choose>
                <xsl:when test="@plec='Kobieta'">
                  <tr bgcolor="pink">
                    <td>
                      <xsl:value-of select="imie"/>
                    </td>
                    <td>
                      <xsl:value-of select="@rasa"/>
                    </td>
                  </tr>
                </xsl:when>
                <xsl:otherwise>
                  <tr bgcolor="blue">
                    <td  >
                      <xsl:value-of select="imie"/>
                    </td>
                  <td>
                      <xsl:value-of select="@rasa"/>
                    </td>
                  </tr>
                </xsl:otherwise>
              </xsl:choose>
            </xsl:if>
          </xsl:for-each>
        </table>
    
        
        
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>

