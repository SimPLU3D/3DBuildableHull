//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.1.3-b01-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2009.10.26 at 12:24:15 PM CET
//

package fr.ign.cogit.gru3d.regleUrba.reglesUrbanismes.regles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import fr.ign.cogit.gru3d.regleUrba.representation.Incoherence;
import fr.ign.cogit.gru3d.regleUrba.schemageo.Parcelle;

/**
 * 
 *        This software is released under the licence CeCILL
 * 
 *        see LICENSE.TXT
 * 
 *        see <http://www.cecill.info/ http://www.cecill.info/
 * 
 * 
 * 
 * @copyright IGN
 * 
 * @author Brasebin Mickaël
 * 
 * @version 1.0
 *
 * <p>
 * Java class for BandeConstructibilite complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="BandeConstructibilite">
 *   &lt;complexContent>
 *     &lt;extension base="{}Consequence">
 *       &lt;sequence>
 *         &lt;element name="fichierBande" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BandeConstructibilite", propOrder = { "fichierBande" })
public class BandeConstructibilite extends Consequence {

  public BandeConstructibilite() {
    super();

  }

  public BandeConstructibilite(String fichierBande) {
    super();
    this.fichierBande = fichierBande;
  }

  @XmlElement(required = true)
  protected String fichierBande;

  /**
   * Gets the value of the fichierBande property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getFichierBande() {
    return this.fichierBande;
  }

  /**
   * Sets the value of the fichierBande property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setFichierBande(String value) {
    this.fichierBande = value;
  }

  @Override
  public String toString() {
    return "Le batiment doit se situer dans les bandes constructibles définies par ce fichier "
        + this.fichierBande;
  }

  @Override
  public List<Incoherence> isConsequenceChecked(Parcelle p, boolean represent) {
    System.out.println("To be implemented (but not very interresting)");
    return new ArrayList<Incoherence>();
  }

}
