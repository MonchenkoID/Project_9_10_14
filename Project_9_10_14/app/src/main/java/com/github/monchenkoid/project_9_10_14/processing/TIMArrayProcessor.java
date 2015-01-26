package com.github.monchenkoid.project_9_10_14.processing;


import com.github.monchenkoid.project_9_10_14.bo.models.TypeInfMet;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class TIMArrayProcessor implements Processor<List<TypeInfMet>, InputStream> {

    @Override
    public List<TypeInfMet> process(InputStream inputStream) throws Exception {

        String string = new StringProcessor().process(inputStream);
        List<TypeInfMet> typeInfMetArray = null;

        return typeInfMetArray;
    }

}
