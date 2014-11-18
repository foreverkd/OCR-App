
package edu.sfsu.cs.orange.ocr;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
//import android.provider.DocumentsContract.Document;
import android.text.LoginFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity to display informational pages to the user in a WebView.
 * 
 * The code for this class was adapted from the ZXing project: http://code.google.com/p/zxing
 */
public final class HelpActivity extends Activity {

  private static final String TAG = HelpActivity.class.getSimpleName();

  // Use this key and one of the values below when launching this activity via intent. If not
  // present, the default page will be loaded.
  public static final String REQUESTED_PAGE_KEY = "";
  public static final String DEFAULT_PAGE = "";
  public static final String ABOUT_PAGE = "";
  public static final String TERMS_PAGE = "";
  public static final String WHATS_NEW_PAGE = "";
  
  String pholder="";
  static String searchQ=CaptureActivity.restext;
  
   
  String dWord=CaptureActivity.restext;

  
 String[] arr = searchQ.split(" ");
  String[]syns=new String[10];
  

  
  
  private static  String BASE_URL = "https://www.google.com/search?q=";
  private static final String WEBVIEW_STATE_PRESENT = "webview_state_present";

  private WebView webView;

  private final Button.OnClickListener doneListener = new Button.OnClickListener() 
  {
    @Override
    public void onClick(View view) {
      finish();
    }
  };

  @Override
  protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.help);
    
    int tempsyn=0;
   // searchQ=searchQ+CaptureActivity.restext;
    
    for(String s: arr)
    {
    System.out.println(""+s);
    }

    

    webView = (WebView)findViewById(R.id.help_contents);
    webView.setWebViewClient(new HelpClient(this));

    Intent intent = getIntent();
    String page = intent.getStringExtra(REQUESTED_PAGE_KEY);
    //TextView tv=(TextView)findViewById(R.id.textView1);
	//TextView tv2=(TextView)findViewById(R.id.textView2);
	
	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);
    String url="http://www.bing.com/search?q=";
	//String synlist="";
	Document doc;
	 Document doc1;
	 
	 int i;
	 //tv.setText("");
	 //tv2.setText("synonyms for computer");
	 //BASE_URL=BASE_URL;
	// String BASE_URL1="";
	 //String BASE_URL2="";
	/*
	 for(String s : arr)
	 {
		 i=0;
		 System.out.println(s);
	 try {
         doc = Jsoup.connect(url+s).get();
         Elements links = doc.select("a[href]");
         for(Element link : links)
         {
        		//System.out.println(link.text());
  	     	  
            	if(i==5)
	            {
            	syns[tempsyn]=""+link.text();
            		System.out.println(link.text());
            		tempsyn++;
            		
	            }
            	i++;
            
            }
         
            
          

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	 }
	 for(int p=0;p<tempsyn;p++)
	 {
		 String starter="|(\"";
		 String closer="\")";
		 String tholder="";
		 for(int h=0;h<tempsyn;h++)
		 {
			 if(h==p)
			 {
				 tholder=tholder+" "+syns[p];
			 }
			 else
			 {
				 tholder=tholder+" "+arr[h];
			 }
		 }
	 }*/
       //tv.setText("cantiloupes");
	 /*
        try {
            doc = Jsoup.connect(url+"art").get();
            Elements links = doc.select("a[href]");
            for(Element link : links)
            {
            	System.out.println(link.text());
            	     	  
            	if((i>=4)&&(i<=6))
	            {
            		//tv.append("\n"+link.text());
            		pholder=link.text()+" programming";
            		BASE_URL=BASE_URL+" or "+pholder+" ";
	            }
            	i++;
            }
            
          

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        i=1;
        pholder="";
        try {
            doc = Jsoup.connect(url+"programming").get();
            Elements links = doc.select("a[href]");
            for(Element link : links)
            {
            	System.out.println(link.text());
            	     	  
            	if((i>=4)&&(i<=6))
	            {
            		//tv.append("\n"+link.text());
            		pholder="art "+link.text();
            		BASE_URL=BASE_URL+" or "+pholder+" ";
	            }
            	i++;
            }
            
          

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
	 
	 //neo
	 String br=searchQ.replace(" ", "+");
	 url=url+br;
	 System.out.println(url);
	 String search_q="";
	 try {
		 
			// need http protocol
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0.1) Gecko/20100101 Firefox/8.0.1").get();
	 
			Elements links = doc.select("div[id=sidebar] ul li a");

	        for (Element element : links) {
	        	System.out.println("goes here");
	        	String sq=element.text().toString();
	        	System.out.println(element.text());
	        	if(!((sq.contains("Bolly")||sq.contains("Buy")||sq.contains("junglee")||sq.contains("India.com"))))
	        	{
	        		System.out.println(sq);
	        	
	        	String s=sq.replace(" ", "+");
	            search_q=search_q+" AND "+s;
	            System.out.println(search_q);
	        	}
	        }
	        System.out.println(search_q);
	 /*
			Elements elementsHtml = doc1.select("#esc-lead-article-title-wrapper"); 
		    for(Element element: elementsHtml)
		    {

		       System.out.println("\nlink : "+ element.attr("href"));
		     
		    }*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	 BASE_URL=BASE_URL+br+search_q;
	 System.out.println(BASE_URL);

        Log.wtf("dada",BASE_URL);
    // Show an OK button.
    View doneButton = findViewById(R.id.done_button);
    doneButton.setOnClickListener(doneListener);

    if (page.equals(DEFAULT_PAGE)) {
      doneButton.setVisibility(View.VISIBLE);
    } else {
      doneButton.setVisibility(View.GONE);
    }

    // Froyo has a bug with calling onCreate() twice in a row, which causes the What's New page
    // that's auto-loaded on first run to appear blank. As a workaround we only call restoreState()
    // if a valid URL was loaded at the time the previous activity was torn down.
    if (icicle != null && icicle.getBoolean(WEBVIEW_STATE_PRESENT, false)) {
      webView.restoreState(icicle);
    } else if (intent != null && page != null && page.length() > 0) {
      webView.loadUrl(BASE_URL + page);
    } else {
      webView.loadUrl(BASE_URL + DEFAULT_PAGE);
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle state) {
    String url = webView.getUrl();
    if (url != null && url.length() > 0) {
      webView.saveState(state);
      state.putBoolean(WEBVIEW_STATE_PRESENT, true);
    }
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      if (webView.canGoBack()) {
        webView.goBack();
        return true;
      }
    }
    return super.onKeyDown(keyCode, event);
  }

  private final class HelpClient extends WebViewClient {
    Activity context;
    public HelpClient(Activity context){
        this.context = context;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
      setTitle(view.getTitle());
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      if (url.startsWith("file")) {
        // Keep local assets in this WebView.
        return false;
      } else if (url.startsWith("mailto:")) {
        try {
              MailTo mt = MailTo.parse(url);
              Intent i = new Intent(Intent.ACTION_SEND);
              i.setType("message/rfc822");
              i.putExtra(Intent.EXTRA_EMAIL, new String[]{mt.getTo()});
              i.putExtra(Intent.EXTRA_SUBJECT, mt.getSubject());
              context.startActivity(i);
              view.reload();
        }
        catch (ActivityNotFoundException e) {
          Log.w(TAG, "Problem with Intent.ACTION_SEND", e);
                  new AlertDialog.Builder(context)
                    .setTitle("Contact Info")
                    .setMessage( "Please send your feedback to: app.ocr@gmail.com" )
                    .setPositiveButton( "Done", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("AlertDialog", "Positive");
                        }
                    })
                    .show();
        }
            return true;
      } else {
        // Open external URLs in Browser.
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        return true;
      }
    }
  }
}