package my.tests.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.github.*;
import org.testng.annotations.Test;

public class GoogleRestApiTest implements IAbstractTest {

    @Test(description = "Learning-api#Task 001")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void getReposTest() {
        GetRepos api = new GetRepos();
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/github/_getRepos/rs.schema");
    }

    @Test(description = "Learning-api#Task 002")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void postRepoTest() {
        PostRepoForAutUser api = new PostRepoForAutUser();
        api.setProperties("api/github/repo.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(description = "Learning-api#Task 003")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void patchUpdateRepoNameTest() {
        PatchUpdateRepoName api = new PatchUpdateRepoName();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(description = "Learning-api#Task 004")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void deleteRepoTest() {
        DeleteRepo api = new DeleteRepo();
        api.callAPIExpectSuccess();
    }

    @Test(description = "Learning-api#Task 005")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void createIssueTest() {
        PostAnIssue api = new PostAnIssue();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(description = "Learning-api#Task 006")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void updateIssueTest() {
        PatchUpdateAnIssue api = new PatchUpdateAnIssue();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(description = "Learning-api#Task 007")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void lockIssueTest() {
        PutLockAnIssue api = new PutLockAnIssue();
        api.callAPIExpectSuccess();
    }

    @Test(description = "Learning-api#Task 008")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void unlockIssueTest() {
        DeleteAnIssue api = new DeleteAnIssue();
        api.callAPIExpectSuccess();
    }

    @Test(description = "Learning-api#Task 009")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void getAutUserTest() {
        GetAutUser api = new GetAutUser();
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/github/_getAutUser/rs.schema");
    }

    @Test(description = "Learning-api#Task 010")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void patchAytUserTest() {
        PatchUpdateAutUser api = new PatchUpdateAutUser();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}
