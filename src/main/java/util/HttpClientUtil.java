package util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpClient工具类
 * 
 * @author 李关钦
 * @version 2016年12月9日
 */
public class HttpClientUtil {

	private static final String CHARSET_UTF8 = "UTF-8";

	private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * 发送GET请求
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doGetWithMap(String url, Map<String, String> param) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultStr = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			log.info("create httpGet : [{}]", uri);

			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultStr = EntityUtils.toString(response.getEntity(), CHARSET_UTF8);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		log.info("result : [{}]", resultStr);

		return resultStr;
	}

	/**
	 * 发送GET请求
	 * 
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		return doGetWithMap(url, null);
	}

	/**
	 * 发送Post请求
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doPostWithMap(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultStr = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}

			log.info("create httpPost : [{}]", httpPost.getURI());

			// 执行http请求
			response = httpClient.execute(httpPost);
			resultStr = EntityUtils.toString(response.getEntity(), CHARSET_UTF8);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		log.info("result : [{}]", resultStr);
		return resultStr;
	}

	/**
	 * 发送不带参数的Post请求
	 * 
	 * @param url
	 * @return
	 */
	public static String doPost(String url) {
		return doPostWithMap(url, null);
	}

	/**
	 * 发送Json格式的Post请求
	 * 
	 * @param url
	 * @param json
	 * @return
	 */
	public static String doPostWithJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultStr = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);

			log.info("create httpPost : [{}]", url);

			// 执行http请求
			response = httpClient.execute(httpPost);
			resultStr = EntityUtils.toString(response.getEntity(), CHARSET_UTF8);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		log.info("result : [{}]", resultStr);

		return resultStr;
	}

	/**
	 * 发送带XML数据的POST请求
	 * 
	 * @param url
	 * @param xml xml字符串
	 * @return
	 * @throws Exception
	 */
	public static String doPostWithXML(String url, String xml) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String resultStr = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(xml, ContentType.TEXT_XML);
			httpPost.setEntity(entity);

			log.info("create httpPost : [{}]", url);

			// 执行http请求
			HttpResponse response = httpClient.execute(httpPost);

			// 返回数据
			resultStr = EntityUtils.toString(response.getEntity(), CHARSET_UTF8);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		log.info("result : [{}]", resultStr);

		return resultStr;
	}
}

