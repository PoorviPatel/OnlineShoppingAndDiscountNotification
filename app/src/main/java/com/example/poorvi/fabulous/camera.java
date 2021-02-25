package com.example.poorvi.fabulous;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class camera extends Fragment {

    ArrayList<HashMap<String, String>> arraylist;
    NodeList nodelist = null;
    String url = "http://api.androidhive.info/pizza/?format=xml";
    //String url = "http://webservices.amazon.com/onca/xml?Service=AWSECommerceServicee&AWSAccessKeyId=AKIAIT2MKFYF5OPAGENQ&Operation=ItemLookup&SubscriptionId=&AssociateTag=&Version=2011-08-01&ItemId=B007IJQDQQ&IdType=ASIN&ResponseGroup=Offers&Condition=All&MerchantId=All";
//http://webservices.amazon.com/onca/xml?Service=AWSECommerceServicee&AWSAccessKeyId=AKIAIT2MKFYF5OPAGENQ&Operation=ItemLookup&Version=2011-08-01&ItemId=B007IJQDQQ&IdType=ASIN&ResponseGroup=Offers&Condition=All&MerchantId=All
    TextView tv1;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.activity_contact_us, container, false);
        setHasOptionsMenu(true);
        tv1=(TextView)v.findViewById(R.id.text);
        new DownloadXML().execute(url);

        return v;
    }

    private class DownloadXML extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... Url) {
            try {
                URL url = new URL(Url[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();
                nodelist = doc.getElementsByTagName("item");
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void args) {
            try{
                Log.e("Len", String.valueOf(nodelist.getLength()));
            for (int temp = 0; temp < nodelist.getLength(); temp++) {
                Node nNode = nodelist.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Log.e("Lenxml", getNode("name",eElement));

                    tv1.setText(tv1.getText() + "\nName : " + getNode("name", eElement) + "\n" + "\n");
                    tv1.setText(tv1.getText() + "Cost : " + getNode("cost", eElement) + "\n" + "\n");
                    tv1.setText(tv1.getText() + "Description : " + getNode("description", eElement) + "\n" + "\n");
                    tv1.setText(tv1.getText() + "--------------------------------------------------------------------------------------------");
                }
            }
            }catch(Exception e){e.printStackTrace();}
        }
    }

    private static String getNode(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}
