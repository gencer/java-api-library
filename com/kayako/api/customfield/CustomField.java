package com.kayako.api.customfield;

import com.kayako.api.exception.KayakoException;
import com.kayako.api.rest.KEntity;
import com.kayako.api.rest.RawArrayElement;
import com.kayako.api.util.Helper;

import java.util.HashMap;

/**
 * The type Custom field.
 *
 * @author Rajat Garg
 * @package api
 * @copyright Copyright (c) 2001-2012, Kayako
 * @license http ://www.kayako.com/license
 * @link http ://www.kayako.com
 */
public class CustomField extends KEntity {

    /**
     * The Object xml name.
     */
    static protected String objectXmlName = "field";
    /**
     * Field identifier.
     *
     * @apiField
     * @var int
     */
    protected int id;

    /**
     * Field type.
     *
     * @apiField
     * @var int
     */
    protected int type;

    /**
     * Field name.
     *
     * @apiField
     * @var string
     */
    protected String name;

    /**
     * Field title.
     *
     * @apiField
     * @var string
     */
    protected String title;

    /**
     * Field value.
     *
     * @apiField name =value getter=getRawValue setter=setValue
     * @var string
     */
    protected String rawValue;

    /**
     * Custom field group this field belongs to.
     *
     * @var CustomFieldGroupBase
     */
    protected CustomFieldGroup customFieldGroup;

    /**
     * Cache for field definition.
     *
     * @var CustomFieldDefinition
     */
    protected CustomFieldDefinition definition = null;

    /**
     * Instantiates a new Custom field.
     *
     * @param customFieldGroup the custom field group
     */
    public CustomField(CustomFieldGroup customFieldGroup) {
        this.customFieldGroup = customFieldGroup;
    }

    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @return the id
     */
    public CustomField setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Get custom field.
     *
     * @param id the id
     * @return the custom field
     * @throws com.kayako.api.exception.KayakoException the kayako exception
     */
    public static CustomField get(int id) throws KayakoException {
        throw new KayakoException("This method is not available for this type of objects.");
    }

    @Override
    public KEntity create(String controller) throws KayakoException {
        throw new KayakoException("This method is not available for this type of objects.");
    }

    @Override
    public Boolean delete(String controller) throws KayakoException {
        throw new KayakoException("This method is not available for this type of objects.");
    }

    @Override
    public KEntity refresh(String controller) throws KayakoException {
        throw new KayakoException("This method is not available for this type of objects.");
    }

    @Override
    public KEntity update(String controller) throws KayakoException {
        throw new KayakoException("This method is not available for this type of objects.");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Gets custom field group.
     *
     * @return the custom field group
     */
    public CustomFieldGroup getCustomFieldGroup() {
        return customFieldGroup;
    }

    /**
     * Sets custom field group.
     *
     * @param customFieldGroup the custom field group
     * @return the custom field group
     */
    public CustomField setCustomFieldGroup(CustomFieldGroup customFieldGroup) {
        this.customFieldGroup = customFieldGroup;
        return this;
    }

    /**
     * Gets definition.
     *
     * @return the definition
     * @throws KayakoException the kayako exception
     */
    public CustomFieldDefinition getDefinition() throws KayakoException {
        return this.getDefinition(false);
    }

    /**
     * Gets definition.
     *
     * @param refresh the refresh
     * @return the definition
     * @throws KayakoException the kayako exception
     */
    public CustomFieldDefinition getDefinition(Boolean refresh) throws KayakoException {
        if (this.definition != null && !refresh) {
            return this.definition;
        }
        this.definition = new CustomFieldDefinition(CustomFieldDefinition.getAll(CustomFieldDefinition.getController()).filterByComponentAttribute("fieldname", this.getName()).getComponents().get(0));
        return this.definition;
    }

    /**
     * Sets definition.
     *
     * @param definition the definition
     * @return the definition
     */
    public CustomField setDefinition(CustomFieldDefinition definition) {
        this.definition = definition;
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public CustomField setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets raw value.
     *
     * @return the raw value
     */
    public String getRawValue() {
        return rawValue;
    }

    /**
     * Sets raw value.
     *
     * @param rawValue the raw value
     * @return the raw value
     */
    public CustomField setRawValue(String rawValue) {
        this.rawValue = rawValue;
        return this;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     * @return the title
     */
    public CustomField setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @return the type
     */
    public CustomField setType(int type) {
        this.type = type;
        return this;
    }

    /**
     * Gets option.
     *
     * @param value the value
     * @return the option
     * @throws KayakoException the kayako exception
     */
    public CustomFieldOption getOption(String value) throws KayakoException {
        int id = Helper.parseInt(value);
        if (id > 0) {
            return this.getOption(id);
        }
        return this.getDefinition().getOptionByValue(value);
    }

    /**
     * Gets option.
     *
     * @param id the id
     * @return the option
     * @throws KayakoException the kayako exception
     */
    public CustomFieldOption getOption(int id) throws KayakoException {
        return this.getDefinition().getOptionById(id);
    }

    /**
     * Gets object xml name.
     *
     * @return the object xml name
     */
    public static String getObjectXmlName() {
        return objectXmlName;
    }

    /**
     * Sets object xml name.
     *
     * @param objectXmlName the object xml name
     */
    public static void setObjectXmlName(String objectXmlName) {
        CustomField.objectXmlName = objectXmlName;
    }

    @Override
    public CustomField populate(RawArrayElement rawArrayElement) throws KayakoException {
        if (!rawArrayElement.getElementName().equals(objectXmlName)) {
            throw new KayakoException();
        }

        //attribute =  title, id  , type, name
        this.setTitle(rawArrayElement.getAttribute("title")).setId(Helper.parseInt(rawArrayElement.getAttribute("id")));
        this.setName(rawArrayElement.getAttribute("name")).setType(Helper.parseInt(rawArrayElement.getAttribute("type")));
        this.setRawValue(rawArrayElement.getContent());
        return this;

    }

    /**
     * Build hash map.
     *
     * @return the hash map
     */
    public HashMap<String, String> buildHashMap() {
        return buildHashMap(false);
    }

    /**
     * Build hash map.
     *
     * @param newCustomField the new custom field
     * @return the hash map
     */
    public HashMap<String, String> buildHashMap(Boolean newCustomField) {
        HashMap<String, String> customFieldHashMap = new HashMap<String, String>();
        customFieldHashMap.put(this.getName(), this.getRawValue());
        return customFieldHashMap;
    }

    public HashMap<String, HashMap<String, String>> buildFilesHashMap() {
        return buildFilesHashMap(false);
    }

    /**
     * Build files hash map.
     *
     * @param newCustomFieldFile the new custom field file
     * @return the hash map
     */
    public HashMap<String, HashMap<String, String>> buildFilesHashMap(Boolean newCustomFieldFile) {
        HashMap<String, HashMap<String, String>> fileHashMap = new HashMap<String, HashMap<String, String>>();
        //This function returns empty hashMap from here
        return fileHashMap;
    }
}
