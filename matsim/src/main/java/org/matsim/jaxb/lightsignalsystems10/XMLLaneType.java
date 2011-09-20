//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.09.20 at 07:20:27 PM MESZ 
//


package org.matsim.jaxb.lightsignalsystems10;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.matsim.jaxb.Adapter1;


/**
 * <p>Java class for laneType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="laneType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.matsim.org/files/dtd}matsimObjectType">
 *       &lt;sequence>
 *         &lt;element name="toLink" type="{http://www.matsim.org/files/dtd}idRefType" maxOccurs="unbounded"/>
 *         &lt;element name="representedLanes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="1" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="length" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="meter" type="{http://www.w3.org/2001/XMLSchema}double" default="45.0" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "laneType", propOrder = {
    "toLink",
    "representedLanes",
    "length"
})
public class XMLLaneType
    extends XMLMatsimObjectType
{

    @XmlElement(required = true)
    protected List<XMLIdRefType> toLink;
    protected XMLLaneType.XMLRepresentedLanes representedLanes;
    protected XMLLaneType.XMLLength length;

    /**
     * Gets the value of the toLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the toLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getToLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLIdRefType }
     * 
     * 
     */
    public List<XMLIdRefType> getToLink() {
        if (toLink == null) {
            toLink = new ArrayList<XMLIdRefType>();
        }
        return this.toLink;
    }

    /**
     * Gets the value of the representedLanes property.
     * 
     * @return
     *     possible object is
     *     {@link XMLLaneType.XMLRepresentedLanes }
     *     
     */
    public XMLLaneType.XMLRepresentedLanes getRepresentedLanes() {
        return representedLanes;
    }

    /**
     * Sets the value of the representedLanes property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLLaneType.XMLRepresentedLanes }
     *     
     */
    public void setRepresentedLanes(XMLLaneType.XMLRepresentedLanes value) {
        this.representedLanes = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link XMLLaneType.XMLLength }
     *     
     */
    public XMLLaneType.XMLLength getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLLaneType.XMLLength }
     *     
     */
    public void setLength(XMLLaneType.XMLLength value) {
        this.length = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="meter" type="{http://www.w3.org/2001/XMLSchema}double" default="45.0" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLLength {

        @XmlAttribute
        protected Double meter;

        /**
         * Gets the value of the meter property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public double getMeter() {
            if (meter == null) {
                return  45.0D;
            } else {
                return meter;
            }
        }

        /**
         * Sets the value of the meter property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setMeter(Double value) {
            this.meter = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="1" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLRepresentedLanes {

        @XmlAttribute
        @XmlJavaTypeAdapter(Adapter1 .class)
        @XmlSchemaType(name = "positiveInteger")
        protected Integer number;

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public int getNumber() {
            if (number == null) {
                return new Adapter1().unmarshal("1");
            } else {
                return number;
            }
        }

        /**
         * Sets the value of the number property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumber(Integer value) {
            this.number = value;
        }

    }

}
