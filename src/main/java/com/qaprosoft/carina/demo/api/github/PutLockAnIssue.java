package com.qaprosoft.carina.demo.api.github;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/repos/DmytroHasiuk/Work-with-issues/issues/4/lock", methodType = HttpMethodType.PUT)
@SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)
public class PutLockAnIssue extends AbstractApiMethodV2 {

    public PutLockAnIssue() {
        CryptoTool cryptoTool = new CryptoTool();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        setHeaders("Accept=application/vnd.github+json", "Authorization=Bearer " +
                cryptoTool.decrypt("37Kr9hjPeuXj4ffR5f6FMw4pFTen49nJSEUb9Cm92yvaum76BFaGwmKzd80pzvbN"));
    }
}
