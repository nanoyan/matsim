//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.25 at 10:54:50 AM CEST 
//


package org.matsim.contrib.matsim4urbansim.matsim4urbansim.jaxbconfigv3;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for matsim_configType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="matsim_configType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cellSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="accessibilityComputationAreaFromShapeFile" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="accessibilityComputationAreaFromBoundingBox" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="accessibilityComputationAreaFromNetwork" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="studyAreaBoundaryShapeFile" type="{}fileType"/>
 *         &lt;element name="boundingBoxTop" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="boundingBoxLeft" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="boundingBoxRight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="boundingBoxBottom" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="urbansimZoneRandomLocationDistributionByRadius" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="urbansimZoneRandomLocationDistributionByShapeFile" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="external_matsim_config" type="{}fileType"/>
 *         &lt;element name="network" type="{}fileType"/>
 *         &lt;element name="warmStartPlansFile" type="{}fileType"/>
 *         &lt;element name="useHotStart" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hotStartPlansFile" type="{}fileType"/>
 *         &lt;element name="activityType_0" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="activityType_1" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="homeActivityTypicalDuration" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="workActivityTypicalDuration" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="workActivityOpeningTime" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="workActivityLatestStartTime" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="firstIteration" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="lastIteration" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matsim_configType", propOrder = {
    "cellSize",
    "accessibilityComputationAreaFromShapeFile",
    "accessibilityComputationAreaFromBoundingBox",
    "accessibilityComputationAreaFromNetwork",
    "studyAreaBoundaryShapeFile",
    "boundingBoxTop",
    "boundingBoxLeft",
    "boundingBoxRight",
    "boundingBoxBottom",
    "urbansimZoneRandomLocationDistributionByRadius",
    "urbansimZoneRandomLocationDistributionByShapeFile",
    "externalMatsimConfig",
    "network",
    "warmStartPlansFile",
    "useHotStart",
    "hotStartPlansFile",
    "activityType0",
    "activityType1",
    "homeActivityTypicalDuration",
    "workActivityTypicalDuration",
    "workActivityOpeningTime",
    "workActivityLatestStartTime",
    "firstIteration",
    "lastIteration"
})
public class MatsimConfigType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cellSize;
    protected boolean accessibilityComputationAreaFromShapeFile;
    protected boolean accessibilityComputationAreaFromBoundingBox;
    protected boolean accessibilityComputationAreaFromNetwork;
    @XmlElement(required = true)
    protected FileType studyAreaBoundaryShapeFile;
    protected double boundingBoxTop;
    protected double boundingBoxLeft;
    protected double boundingBoxRight;
    protected double boundingBoxBottom;
    protected double urbansimZoneRandomLocationDistributionByRadius;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String urbansimZoneRandomLocationDistributionByShapeFile;
    @XmlElement(name = "external_matsim_config", required = true)
    protected FileType externalMatsimConfig;
    @XmlElement(required = true)
    protected FileType network;
    @XmlElement(required = true)
    protected FileType warmStartPlansFile;
    protected boolean useHotStart;
    @XmlElement(required = true)
    protected FileType hotStartPlansFile;
    @XmlElement(name = "activityType_0", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String activityType0;
    @XmlElement(name = "activityType_1", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String activityType1;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger homeActivityTypicalDuration;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger workActivityTypicalDuration;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger workActivityOpeningTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger workActivityLatestStartTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger firstIteration;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger lastIteration;

    /**
     * Gets the value of the cellSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCellSize() {
        return cellSize;
    }

    /**
     * Sets the value of the cellSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCellSize(BigInteger value) {
        this.cellSize = value;
    }

    /**
     * Gets the value of the accessibilityComputationAreaFromShapeFile property.
     * 
     */
    public boolean isAccessibilityComputationAreaFromShapeFile() {
        return accessibilityComputationAreaFromShapeFile;
    }

    /**
     * Sets the value of the accessibilityComputationAreaFromShapeFile property.
     * 
     */
    public void setAccessibilityComputationAreaFromShapeFile(boolean value) {
        this.accessibilityComputationAreaFromShapeFile = value;
    }

    /**
     * Gets the value of the accessibilityComputationAreaFromBoundingBox property.
     * 
     */
    public boolean isAccessibilityComputationAreaFromBoundingBox() {
        return accessibilityComputationAreaFromBoundingBox;
    }

    /**
     * Sets the value of the accessibilityComputationAreaFromBoundingBox property.
     * 
     */
    public void setAccessibilityComputationAreaFromBoundingBox(boolean value) {
        this.accessibilityComputationAreaFromBoundingBox = value;
    }

    /**
     * Gets the value of the accessibilityComputationAreaFromNetwork property.
     * 
     */
    public boolean isAccessibilityComputationAreaFromNetwork() {
        return accessibilityComputationAreaFromNetwork;
    }

    /**
     * Sets the value of the accessibilityComputationAreaFromNetwork property.
     * 
     */
    public void setAccessibilityComputationAreaFromNetwork(boolean value) {
        this.accessibilityComputationAreaFromNetwork = value;
    }

    /**
     * Gets the value of the studyAreaBoundaryShapeFile property.
     * 
     * @return
     *     possible object is
     *     {@link FileType }
     *     
     */
    public FileType getStudyAreaBoundaryShapeFile() {
        return studyAreaBoundaryShapeFile;
    }

    /**
     * Sets the value of the studyAreaBoundaryShapeFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileType }
     *     
     */
    public void setStudyAreaBoundaryShapeFile(FileType value) {
        this.studyAreaBoundaryShapeFile = value;
    }

    /**
     * Gets the value of the boundingBoxTop property.
     * 
     */
    public double getBoundingBoxTop() {
        return boundingBoxTop;
    }

    /**
     * Sets the value of the boundingBoxTop property.
     * 
     */
    public void setBoundingBoxTop(double value) {
        this.boundingBoxTop = value;
    }

    /**
     * Gets the value of the boundingBoxLeft property.
     * 
     */
    public double getBoundingBoxLeft() {
        return boundingBoxLeft;
    }

    /**
     * Sets the value of the boundingBoxLeft property.
     * 
     */
    public void setBoundingBoxLeft(double value) {
        this.boundingBoxLeft = value;
    }

    /**
     * Gets the value of the boundingBoxRight property.
     * 
     */
    public double getBoundingBoxRight() {
        return boundingBoxRight;
    }

    /**
     * Sets the value of the boundingBoxRight property.
     * 
     */
    public void setBoundingBoxRight(double value) {
        this.boundingBoxRight = value;
    }

    /**
     * Gets the value of the boundingBoxBottom property.
     * 
     */
    public double getBoundingBoxBottom() {
        return boundingBoxBottom;
    }

    /**
     * Sets the value of the boundingBoxBottom property.
     * 
     */
    public void setBoundingBoxBottom(double value) {
        this.boundingBoxBottom = value;
    }

    /**
     * Gets the value of the urbansimZoneRandomLocationDistributionByRadius property.
     * 
     */
    public double getUrbansimZoneRandomLocationDistributionByRadius() {
        return urbansimZoneRandomLocationDistributionByRadius;
    }

    /**
     * Sets the value of the urbansimZoneRandomLocationDistributionByRadius property.
     * 
     */
    public void setUrbansimZoneRandomLocationDistributionByRadius(double value) {
        this.urbansimZoneRandomLocationDistributionByRadius = value;
    }

    /**
     * Gets the value of the urbansimZoneRandomLocationDistributionByShapeFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrbansimZoneRandomLocationDistributionByShapeFile() {
        return urbansimZoneRandomLocationDistributionByShapeFile;
    }

    /**
     * Sets the value of the urbansimZoneRandomLocationDistributionByShapeFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrbansimZoneRandomLocationDistributionByShapeFile(String value) {
        this.urbansimZoneRandomLocationDistributionByShapeFile = value;
    }

    /**
     * Gets the value of the externalMatsimConfig property.
     * 
     * @return
     *     possible object is
     *     {@link FileType }
     *     
     */
    public FileType getExternalMatsimConfig() {
        return externalMatsimConfig;
    }

    /**
     * Sets the value of the externalMatsimConfig property.
     * 
     * @param matsimConfigInputFile
     *     allowed object is
     *     {@link FileType }
     *     
     */
    public void setExternalMatsimConfig(FileType matsimConfigInputFile) {
        this.externalMatsimConfig = matsimConfigInputFile;
    }

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link FileType }
     *     
     */
    public FileType getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileType }
     *     
     */
    public void setNetwork(FileType value) {
        this.network = value;
    }

    /**
     * Gets the value of the warmStartPlansFile property.
     * 
     * @return
     *     possible object is
     *     {@link FileType }
     *     
     */
    public FileType getWarmStartPlansFile() {
        return warmStartPlansFile;
    }

    /**
     * Sets the value of the warmStartPlansFile property.
     * 
     * @param hotstartPlansFile2
     *     allowed object is
     *     {@link FileType }
     *     
     */
    public void setWarmStartPlansFile(FileType hotstartPlansFile2) {
        this.warmStartPlansFile = hotstartPlansFile2;
    }

    /**
     * Gets the value of the useHotStart property.
     * 
     */
    public boolean isUseHotStart() {
        return useHotStart;
    }

    /**
     * Sets the value of the useHotStart property.
     * 
     */
    public void setUseHotStart(boolean value) {
        this.useHotStart = value;
    }

    /**
     * Gets the value of the hotStartPlansFile property.
     * 
     * @return
     *     possible object is
     *     {@link FileType }
     *     
     */
    public FileType getHotStartPlansFile() {
        return hotStartPlansFile;
    }

    /**
     * Sets the value of the hotStartPlansFile property.
     * 
     * @param hotstartPlansFile2
     *     allowed object is
     *     {@link FileType }
     *     
     */
    public void setHotStartPlansFile(FileType hotstartPlansFile2) {
        this.hotStartPlansFile = hotstartPlansFile2;
    }

    /**
     * Gets the value of the activityType0 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityType0() {
        return activityType0;
    }

    /**
     * Sets the value of the activityType0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityType0(String value) {
        this.activityType0 = value;
    }

    /**
     * Gets the value of the activityType1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityType1() {
        return activityType1;
    }

    /**
     * Sets the value of the activityType1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityType1(String value) {
        this.activityType1 = value;
    }

    /**
     * Gets the value of the homeActivityTypicalDuration property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHomeActivityTypicalDuration() {
        return homeActivityTypicalDuration;
    }

    /**
     * Sets the value of the homeActivityTypicalDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHomeActivityTypicalDuration(BigInteger value) {
        this.homeActivityTypicalDuration = value;
    }

    /**
     * Gets the value of the workActivityTypicalDuration property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWorkActivityTypicalDuration() {
        return workActivityTypicalDuration;
    }

    /**
     * Sets the value of the workActivityTypicalDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWorkActivityTypicalDuration(BigInteger value) {
        this.workActivityTypicalDuration = value;
    }

    /**
     * Gets the value of the workActivityOpeningTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWorkActivityOpeningTime() {
        return workActivityOpeningTime;
    }

    /**
     * Sets the value of the workActivityOpeningTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWorkActivityOpeningTime(BigInteger value) {
        this.workActivityOpeningTime = value;
    }

    /**
     * Gets the value of the workActivityLatestStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWorkActivityLatestStartTime() {
        return workActivityLatestStartTime;
    }

    /**
     * Sets the value of the workActivityLatestStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWorkActivityLatestStartTime(BigInteger value) {
        this.workActivityLatestStartTime = value;
    }

    /**
     * Gets the value of the firstIteration property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFirstIteration() {
        return firstIteration;
    }

    /**
     * Sets the value of the firstIteration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFirstIteration(BigInteger value) {
        this.firstIteration = value;
    }

    /**
     * Gets the value of the lastIteration property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLastIteration() {
        return lastIteration;
    }

    /**
     * Sets the value of the lastIteration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLastIteration(BigInteger value) {
        this.lastIteration = value;
    }

}