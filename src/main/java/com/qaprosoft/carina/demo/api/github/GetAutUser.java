package com.qaprosoft.carina.demo.api.github;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/user", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/github/_getAutUser/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAutUser extends AbstractApiMethodV2 {

    public GetAutUser() {
        CryptoTool cryptoTool = new CryptoTool();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        setHeaders("Accept=application/vnd.github+json", "Authorization=Bearer "+
                cryptoTool.decrypt("37Kr9hjPeuXj4ffR5f6FMw4pFTen49nJSEUb9Cm92yvaum76BFaGwmKzd80pzvbN"));
    }
}
