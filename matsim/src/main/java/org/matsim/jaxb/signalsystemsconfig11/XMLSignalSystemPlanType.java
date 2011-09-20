//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.09.20 at 07:22:03 PM MESZ 
//


package org.matsim.jaxb.signalsystemsconfig11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.matsim.jaxb.Adapter1;


/**
 *  This type specifies a plan for a traffic light system.
 *     
 * 
 * <p>Java class for signalSystemPlanType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signalSystemPlanType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.matsim.org/files/dtd}matsimObjectType">
 *       &lt;sequence>
 *         &lt;element name="start">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="daytime" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="stop">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="daytime" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cycleTime">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="sec" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="synchronizationOffset" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="sec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="powerOnTime" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="sec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="powerOffTime" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="sec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="signalGroupSettings" type="{http://www.matsim.org/files/dtd}signalGroupSettingsType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signalSystemPlanType", propOrder = {
    "start",
    "stop",
    "cycleTime",
    "synchronizationOffset",
    "powerOnTime",
    "powerOffTime",
    "signalGroupSettings"
})
public class XMLSignalSystemPlanType
    extends XMLMatsimObjectType
{

    @XmlElement(required = true)
    protected XMLSignalSystemPlanType.XMLStart start;
    @XmlElement(required = true)
    protected XMLSignalSystemPlanType.XMLStop stop;
    @XmlElement(required = true)
    protected XMLSignalSystemPlanType.XMLCycleTime cycleTime;
    protected XMLSignalSystemPlanType.XMLSynchronizationOffset synchronizationOffset;
    protected XMLSignalSystemPlanType.XMLPowerOnTime powerOnTime;
    protected XMLSignalSystemPlanType.XMLPowerOffTime powerOffTime;
    @XmlElement(required = true)
    protected List<XMLSignalGroupSettingsType> signalGroupSettings;

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLSignalSystemPlanType.XMLStart }
     *     
     */
    public XMLSignalSystemPlanType.XMLStart getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSignalSystemPlanType.XMLStart }
     *     
     */
    public void setStart(XMLSignalSystemPlanType.XMLStart value) {
        this.start = value;
    }

    /**
     * Gets the value of the stop property.
     * 
     * @return
     *     possible object is
     *     {@link XMLSignalSystemPlanType.XMLStop }
     *     
     */
    public XMLSignalSystemPlanType.XMLStop getStop() {
        return stop;
    }

    /**
     * Sets the value of the stop property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSignalSystemPlanType.XMLStop }
     *     
     */
    public void setStop(XMLSignalSystemPlanType.XMLStop value) {
        this.stop = value;
    }

    /**
     * Gets the value of the cycleTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLSignalSystemPlanType.XMLCycleTime }
     *     
     */
    public XMLSignalSystemPlanType.XMLCycleTime getCycleTime() {
        return cycleTime;
    }

    /**
     * Sets the value of the cycleTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSignalSystemPlanType.XMLCycleTime }
     *     
     */
    public void setCycleTime(XMLSignalSystemPlanType.XMLCycleTime value) {
        this.cycleTime = value;
    }

    /**
     * Gets the value of the synchronizationOffset property.
     * 
     * @return
     *     possible object is
     *     {@link XMLSignalSystemPlanType.XMLSynchronizationOffset }
     *     
     */
    public XMLSignalSystemPlanType.XMLSynchronizationOffset getSynchronizationOffset() {
        return synchronizationOffset;
    }

    /**
     * Sets the value of the synchronizationOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSignalSystemPlanType.XMLSynchronizationOffset }
     *     
     */
    public void setSynchronizationOffset(XMLSignalSystemPlanType.XMLSynchronizationOffset value) {
        this.synchronizationOffset = value;
    }

    /**
     * Gets the value of the powerOnTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLSignalSystemPlanType.XMLPowerOnTime }
     *     
     */
    public XMLSignalSystemPlanType.XMLPowerOnTime getPowerOnTime() {
        return powerOnTime;
    }

    /**
     * Sets the value of the powerOnTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSignalSystemPlanType.XMLPowerOnTime }
     *     
     */
    public void setPowerOnTime(XMLSignalSystemPlanType.XMLPowerOnTime value) {
        this.powerOnTime = value;
    }

    /**
     * Gets the value of the powerOffTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLSignalSystemPlanType.XMLPowerOffTime }
     *     
     */
    public XMLSignalSystemPlanType.XMLPowerOffTime getPowerOffTime() {
        return powerOffTime;
    }

    /**
     * Sets the value of the powerOffTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSignalSystemPlanType.XMLPowerOffTime }
     *     
     */
    public void setPowerOffTime(XMLSignalSystemPlanType.XMLPowerOffTime value) {
        this.powerOffTime = value;
    }

    /**
     * Gets the value of the signalGroupSettings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signalGroupSettings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignalGroupSettings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLSignalGroupSettingsType }
     * 
     * 
     */
    public List<XMLSignalGroupSettingsType> getSignalGroupSettings() {
        if (signalGroupSettings == null) {
            signalGroupSettings = new ArrayList<XMLSignalGroupSettingsType>();
        }
        return this.signalGroupSettings;
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
     *       &lt;attribute name="sec" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLCycleTime {

        @XmlAttribute(required = true)
        @XmlJavaTypeAdapter(Adapter1 .class)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected Integer sec;

        /**
         * Gets the value of the sec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public Integer getSec() {
            return sec;
        }

        /**
         * Sets the value of the sec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSec(Integer value) {
            this.sec = value;
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
     *       &lt;attribute name="sec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLPowerOffTime {

        @XmlAttribute
        @XmlJavaTypeAdapter(Adapter1 .class)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected Integer sec;

        /**
         * Gets the value of the sec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public int getSec() {
            if (sec == null) {
                return new Adapter1().unmarshal("0");
            } else {
                return sec;
            }
        }

        /**
         * Sets the value of the sec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSec(Integer value) {
            this.sec = value;
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
     *       &lt;attribute name="sec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLPowerOnTime {

        @XmlAttribute
        @XmlJavaTypeAdapter(Adapter1 .class)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected Integer sec;

        /**
         * Gets the value of the sec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public int getSec() {
            if (sec == null) {
                return new Adapter1().unmarshal("0");
            } else {
                return sec;
            }
        }

        /**
         * Sets the value of the sec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSec(Integer value) {
            this.sec = value;
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
     *       &lt;attribute name="daytime" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLStart {

        @XmlAttribute(required = true)
        @XmlSchemaType(name = "time")
        protected XMLGregorianCalendar daytime;

        /**
         * Gets the value of the daytime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDaytime() {
            return daytime;
        }

        /**
         * Sets the value of the daytime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDaytime(XMLGregorianCalendar value) {
            this.daytime = value;
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
     *       &lt;attribute name="daytime" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLStop {

        @XmlAttribute(required = true)
        @XmlSchemaType(name = "time")
        protected XMLGregorianCalendar daytime;

        /**
         * Gets the value of the daytime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDaytime() {
            return daytime;
        }

        /**
         * Sets the value of the daytime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDaytime(XMLGregorianCalendar value) {
            this.daytime = value;
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
     *       &lt;attribute name="sec" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class XMLSynchronizationOffset {

        @XmlAttribute
        @XmlJavaTypeAdapter(Adapter1 .class)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected Integer sec;

        /**
         * Gets the value of the sec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public int getSec() {
            if (sec == null) {
                return new Adapter1().unmarshal("0");
            } else {
                return sec;
            }
        }

        /**
         * Sets the value of the sec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSec(Integer value) {
            this.sec = value;
        }

    }

}
