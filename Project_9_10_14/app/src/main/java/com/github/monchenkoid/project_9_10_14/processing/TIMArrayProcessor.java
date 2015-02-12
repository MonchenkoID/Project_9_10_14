package com.github.monchenkoid.project_9_10_14.processing;


import com.github.monchenkoid.project_9_10_14.bo.models.TIMresponse;
import com.github.monchenkoid.project_9_10_14.bo.models.TypeInfMet;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class TIMArrayProcessor implements Processor<List<TypeInfMet>, InputStream>
{

	@Override
	public List<TypeInfMet> process(InputStream inputStream) throws Exception
	{
		Gson gson = new Gson();
		JSONObject jsonObject = new JSONObject();
		//String string = new StringProcessor().process(inputStream);
		//jsonObject = new JSONObject(string).getJSONObject("responce");

	//	TIMresponse timResponse = gson.fromJson(inputStream, TIMresponse.class);
		TIMresponse timResponse = null;
		return timResponse.getItems();
	}

}
