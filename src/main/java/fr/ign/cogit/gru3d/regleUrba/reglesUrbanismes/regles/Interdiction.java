//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.1.3-b01-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2009.10.26 at 12:24:15 PM CET
//
package fr.ign.cogit.gru3d.regleUrba.reglesUrbanismes.regles;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.media.j3d.Billboard;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Font3D;
import javax.media.j3d.FontExtrusion;
import javax.media.j3d.Geometry;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.PointArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Text3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import fr.ign.cogit.geoxygene.api.spatial.coordgeom.IDirectPosition;
import fr.ign.cogit.geoxygene.api.spatial.geomprim.IOrientableSurface;
import fr.ign.cogit.geoxygene.sig3d.convert.java3d.ConversionJava3DGeOxygene;
import fr.ign.cogit.geoxygene.spatial.geomprim.GM_OrientableSurface;
import fr.ign.cogit.gru3d.regleUrba.Executor;
import fr.ign.cogit.gru3d.regleUrba.representation.Incoherence;
import fr.ign.cogit.gru3d.regleUrba.schemageo.Parcelle;
import fr.ign.cogit.gru3d.regleUrba.util.Prospect;

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
 * Java class for Interdiction complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Interdiction">
 *   &lt;complexContent>
 *     &lt;extension base="{}Consequence">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Interdiction")
public class Interdiction extends Consequence {

  @Override
  public String toString() {
    return "Construction impossible";
  }

  public Interdiction() {
    this.description = "coin";
  }

  @Override
  public String getDescription() {
    return this.toString();
  }

  // Renvoie false si la parcelle est construite
  @Override
  public List<Incoherence> isConsequenceChecked(Parcelle p, boolean represent) {

    List<Incoherence> lIncoherences = new ArrayList<Incoherence>();

    if (p.getlBatimentsContenus().size() > 0) {
      if (Executor.VERBOSE) {
        System.out.println("Conséquence non vérifiée : parcelle construite");

      }
      
      
      if(represent){
        lIncoherences.add(new Incoherence(this, p, this.generateBranchGroup(p)));
      }else{
       lIncoherences.add(null);
      }

     
    }

    if (Executor.VERBOSE) {
      if (lIncoherences.size() == 0) {
        System.out.println("Conséquence vérifiée : parcelle non construite");
      }
    }

    return lIncoherences;
  }

  private BranchGroup generateBranchGroup(Parcelle p) {
    BranchGroup bg = new BranchGroup();

    IDirectPosition dp = p.getGeom().centroid();

    PointArray pA = new PointArray(1, GeometryArray.COORDINATES
        | GeometryArray.COLOR_3);

    pA.setCapability(GeometryArray.ALLOW_COLOR_READ);
    pA.setCapability(GeometryArray.ALLOW_COLOR_WRITE);

    // Rotation en X, en Y et en Z
    Transform3D rotX = new Transform3D();
    rotX.rotX(0);// -Math.PI / 2.0);
    TransformGroup tgRotX = new TransformGroup(rotX);
    tgRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

    Transform3D rotY = new Transform3D();
    rotY.rotY(0);
    TransformGroup tgRotY = new TransformGroup(rotY);
    tgRotY.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

    Transform3D rotZ = new Transform3D();
    rotZ.rotZ(0);
    TransformGroup tgRotZ = new TransformGroup(rotZ);
    tgRotZ.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

    Font3D f3d = new Font3D(new Font("Arial", Font.PLAIN, 1),
        new FontExtrusion());
    Text3D text3D = new Text3D(f3d, "X", new Point3f(0, 0, 0),
        Text3D.ALIGN_CENTER, Text3D.PATH_RIGHT);

    text3D.setCapability(Text3D.ALLOW_FONT3D_WRITE);
    text3D.setCapability(Geometry.ALLOW_INTERSECT);

    Shape3D s3D1 = new Shape3D();
    s3D1.setGeometry(text3D);
    s3D1.setAppearance(Prospect.genereApparence(true, Color.red, 0, true));

    s3D1.setCapability(Shape3D.ALLOW_APPEARANCE_WRITE);
    s3D1.setCapability(Shape3D.ALLOW_APPEARANCE_READ);

    // On place le centre de la sphère aux bonnes coordonnées
    Transform3D translate = new Transform3D();
    translate.set(new Vector3f((float) dp.getX(), (float) dp.getY(), 60));

    TransformGroup objScale = new TransformGroup();
    Transform3D t3d = new Transform3D();
    t3d.setScale(10);
    objScale.setTransform(t3d);
    objScale.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

    TransformGroup tg1 = new TransformGroup(translate);

    // Create the transformgroup used for the billboard
    TransformGroup billBoardGroup = new TransformGroup();
    // Set the access rights to the group
    billBoardGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    // Add the cube to the group
    billBoardGroup.addChild(s3D1);

    Billboard myBillboard = new Billboard(billBoardGroup,

    Billboard.ROTATE_ABOUT_POINT, new Vector3f());

    myBillboard.setSchedulingBounds(billBoardGroup.getBounds());

    objScale.addChild(billBoardGroup);
    objScale.addChild(myBillboard);

    tgRotZ.addChild(objScale);
    tgRotY.addChild(tgRotZ);
    tgRotX.addChild(tgRotY);

    tg1.addChild(tgRotX);

    bg.addChild(tg1);

    List<IOrientableSurface> lSurface = new ArrayList<IOrientableSurface>(1);
    lSurface.add((GM_OrientableSurface) p.getGeom());
    Shape3D shape = new Shape3D(ConversionJava3DGeOxygene
        .fromOrientableSToTriangleArray(lSurface).getGeometryArray(),
        Prospect.genereApparence(true, Color.red, 0, true));

    bg.addChild(shape);

    return bg;

  }
}
