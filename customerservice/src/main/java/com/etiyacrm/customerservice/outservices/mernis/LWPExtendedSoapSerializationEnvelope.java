package com.etiyacrm.customerservice.outservices.mernis;
//------------------------------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 8.0.1.2
//
// Created by Quasar Development 
//
// This class has been generated for test purposes only and cannot be used in any commercial project.
// To use it in commercial project, you need to generate this class again with Premium account.
// Check https://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
//
// Licence: F17C27A5423B78425C70A70706EFDEB56DC8E3C99D2638D5BBEACBA80B5895948A78718C0120E0982AFDAB0F654504553DB24F86CD2FC2F4F970AEA9EE9CB5D1
//------------------------------------------------------------------------

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.*;
import org.kxml2.io.KXmlParser;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;


class LWPSoapFaultEx extends org.ksoap2.SoapFault
{
    public Object fault;
}

//If you have a compilation error here then you have to add a reference to ExKsoap2.jar to your project (you can find it in Libs folder in the generated zip file)
public class LWPExtendedSoapSerializationEnvelope extends com.easywsdl.exksoap2.serialization.ExSoapSerializationEnvelope {
    static HashMap< java.lang.String,java.lang.Class> classNames = new HashMap< java.lang.String, java.lang.Class>();
    public static String TAG="easyWSDL";

    protected static final int QNAME_NAMESPACE = 0;
    private static final String TYPE_LABEL = "type";
    public boolean enableLogging;

    public static void setDateTimeConverter(LWPDateTimeConverter converter)
    {
        if(converter==null)
        {
            converter = new LWPStandardDateTimeConverter();
        }
        dateTimeConverter=converter;
    }

    public static LWPDateTimeConverter getDateTimeConverter()
    {
        return dateTimeConverter;
    }

    private static LWPDateTimeConverter dateTimeConverter = new LWPStandardDateTimeConverter();

    public LWPExtendedSoapSerializationEnvelope() {
        this(SoapEnvelope.VER11);
    }

    public LWPExtendedSoapSerializationEnvelope(int soapVersion) {
        super(soapVersion);
        implicitTypes = true;
        setAddAdornments(false);
        new LWPMarshalGuid().register(this);
        new MarshalFloat().register(this);
    }


    @Override
    public void writeBody(XmlSerializer writer) throws IOException {
        if(this.bodyOut instanceof SoapObject)
        {
            SoapObject root=(SoapObject)this.bodyOut;
            if(root.getName().equals("") && root.getNamespace().equals(""))
            {
                Field declaredField =  null;
                try {

                    Vector multiRef = new Vector();
                    multiRef.addElement(this.bodyOut);

                    declaredField = SoapSerializationEnvelope.class.getDeclaredField("multiRef");
                    boolean accessible = declaredField.isAccessible();
                    declaredField.setAccessible(true);
                    declaredField.set(this, multiRef);
                    declaredField.setAccessible(accessible);

                } catch (NoSuchFieldException
                        | SecurityException
                        | IllegalArgumentException
                        | IllegalAccessException e) {
                    e.printStackTrace();
                }

                this.writeElement(writer, this.bodyOut, (PropertyInfo)null, null);
                return;
            }
        }
        super.writeBody(writer);
    }

    @Override
    protected void writeProperty(XmlSerializer writer, java.lang.Object obj, PropertyInfo type) throws IOException {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (obj == null || obj== SoapPrimitive.NullNilElement) {
            writer.attribute(xsi, version >= VER12 ? NIL_LABEL : NULL_LABEL, "true");
            return;
        }
        if(writeReferenceObject(writer,obj))
        {
            return;
        }
        java.lang.Object[] qName = getInfo(null, obj);
        if (!type.multiRef && qName[2] == null )
        {
            if (!implicitTypes || (obj.getClass() != type.type && !(obj instanceof Vector ) && type.type!=java.lang.String.class  )) {
                java.lang.String xmlName=LWPHelper.getKeyByValue(classNames,obj.getClass());
                if(xmlName!=null) {
                    java.lang.String[] parts = xmlName.split("\\^\\^");
                    java.lang.String prefix = writer.getPrefix(parts[0], true);
                    writer.attribute(xsi, TYPE_LABEL, prefix + ":" + parts[1]);
                }
                else
                {
                    if(type.type instanceof String) {
                        java.lang.String xsdPrefix = writer.getPrefix(xsd, true);
                        java.lang.String myType = (java.lang.String) type.type;
                        java.lang.String[] parts = myType.split("\\^\\^");
                        if (parts.length == 2) {
                            xsdPrefix = writer.getPrefix(parts[0], true);
                            myType = parts[1];
                        }

                        writer.attribute(xsi, TYPE_LABEL, xsdPrefix + ":" + myType);
                    }
                    else
                    {
                        java.lang.String prefix = writer.getPrefix(type.namespace, true);
                        writer.attribute(xsi, TYPE_LABEL, prefix + ":" + obj.getClass().getSimpleName());
                    }

                }
            }
            //super.writeProperty(writer,obj,type);

            //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
            //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
            writeElement(writer, obj, type, qName[QNAME_MARSHAL]);
        }
        else {
            super.writeProperty(writer, obj, type);
        }
    }

    public SoapObject GetExceptionDetail(Element detailElement,java.lang.String exceptionElementNS,java.lang.String exceptionElementName)
    {
        int index=detailElement.indexOf(exceptionElementNS,exceptionElementName,0);
        if(index>-1)
        {
            Element errorElement=detailElement.getElement(index);
            return GetSoapObject(errorElement);
        }
        return null;
    }

    public SoapObject GetSoapObject(Element detailElement) {
        try{
            XmlSerializer xmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            detailElement.write(xmlSerializer);
            xmlSerializer.flush();

            XmlPullParser xpp = new KXmlParser();
            xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);

            xpp.setInput(new StringReader(writer.toString()));
            xpp.nextTag();
            SoapObject soapObj = new SoapObject(detailElement.getNamespace(),detailElement.getName());
            readSerializable(xpp,soapObj);
            return soapObj;
        }
        catch (java.lang.Exception e)
        {
			if(enableLogging)
			{

			}
        }
        return null;
    }

    public java.lang.Object GetHeader(Element detailElement) {
        if(detailElement.getChildCount()>0 && detailElement.getText(0)!=null)
        {
            SoapPrimitive primitive = new SoapPrimitive(detailElement.getNamespace(),detailElement.getName(),detailElement.getText(0));
            return  primitive;
        }
    
        return GetSoapObject(detailElement);
    }
    private Object createObject(Object soap, Class cl) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object obj=cl.newInstance();
        Method ctor = obj.getClass().getMethod("loadFromSoap",Object.class,LWPExtendedSoapSerializationEnvelope.class);
        ctor.invoke(obj,soap,this);
        return obj;
    }

    public java.lang.Object get(java.lang.Object soap,java.lang.Class cl,boolean typeFromClass)
    {
        if(soap==null)
        {
            return null;
        }
        try
        {
            if(typeFromClass)
            {
                return createObject(soap, cl);
            }
            java.lang.Object refAttr=getReference(soap);
            if (refAttr != null)
            {
                return refAttr;
            }
            else
            {
                if(soap instanceof SoapObject)
                {
                    if(cl ==SoapObject.class)
                    {
                        return soap;
                    }
                    java.lang.String key=String.format("%s^^%s",((SoapObject)soap).getNamespace(),((SoapObject)soap).getName());
                    if(classNames.containsKey(key))
                    {
                        cl=classNames.get(key);
                    }
                }
                return createObject(soap, cl);
            }
        }
        catch (java.lang.Exception e)
        {
			if(enableLogging)
			{

			}
            return null;
        }
    }


    public java.lang.Object getSpecificType(java.lang.Object obj)
    {
        if(obj==null)
        {
            return null;
        }
        if(obj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)obj;
            java.lang.String key=soapObject.getNamespace()+"^^"+soapObject.getName();
            if(classNames.containsKey(key))
            {
                java.lang.Class cl=classNames.get(key);
                try
                {
                    return createObject(soapObject, cl);
                } 
                catch (java.lang.Exception e)
                {
					if(enableLogging)
					{

					}
                }
            }
        }

        return obj;
    }

    public static java.lang.Object getXSDType(java.lang.Object param)
    {
        if(param==null)
        {
            return null;
        }
        java.lang.Class obj=param.getClass();
        if(obj.equals(java.lang.String.class))
        {
            return "string";
        }
        if(obj.equals(int.class) || obj.equals(java.lang.Integer.class))
        {
            return "int";
        }
        if(obj.equals(float.class) || obj.equals(java.lang.Float.class))
        {
            return "float";
        }
        if(obj.equals(double.class) || obj.equals(java.lang.Double.class))
        {
            return "double";
        }
        if(obj.equals(java.math.BigDecimal.class))
        {
            return "decimal";
        }
        if(obj.equals(short.class) || obj.equals(java.lang.Short.class))
        {
            return "short";
        }
        if(obj.equals(long.class) || obj.equals(java.lang.Long.class))
        {
            return "long";
        }
        if(obj.equals(boolean.class) || obj.equals(java.lang.Boolean.class))
        {
            return "boolean";
        }
        java.lang.String xmlName=LWPHelper.getKeyByValue(classNames,obj);
        if(xmlName==null)
        {
            return obj;
        }
        return xmlName;
    }
} 
