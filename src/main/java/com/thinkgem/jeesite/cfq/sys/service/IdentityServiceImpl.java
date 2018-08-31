package com.thinkgem.jeesite.cfq.sys.service;

import java.util.List;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.identity.NativeGroupQuery;
import org.activiti.engine.identity.NativeUserQuery;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.NativeGroupQueryImpl;
import org.activiti.engine.impl.NativeUserQueryImpl;
import org.activiti.engine.impl.ServiceImpl;
import org.activiti.engine.impl.cmd.CheckPassword;
import org.activiti.engine.impl.cmd.CreateGroupCmd;
import org.activiti.engine.impl.cmd.CreateGroupQueryCmd;
import org.activiti.engine.impl.cmd.CreateMembershipCmd;
import org.activiti.engine.impl.cmd.CreateUserCmd;
import org.activiti.engine.impl.cmd.CreateUserQueryCmd;
import org.activiti.engine.impl.cmd.DeleteGroupCmd;
import org.activiti.engine.impl.cmd.DeleteMembershipCmd;
import org.activiti.engine.impl.cmd.DeleteUserCmd;
import org.activiti.engine.impl.cmd.DeleteUserInfoCmd;
import org.activiti.engine.impl.cmd.GetUserInfoCmd;
import org.activiti.engine.impl.cmd.GetUserInfoKeysCmd;
import org.activiti.engine.impl.cmd.GetUserPictureCmd;
import org.activiti.engine.impl.cmd.SaveGroupCmd;
import org.activiti.engine.impl.cmd.SaveUserCmd;
import org.activiti.engine.impl.cmd.SetUserInfoCmd;
import org.activiti.engine.impl.cmd.SetUserPictureCmd;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.springframework.stereotype.Service;

/**
 * @Author: ykbian
 * @Date: 2018/8/31 9:55
 * @Todo:  org中的IdentityService注入失败，自己写一个。
 */
@Service
public class IdentityServiceImpl extends ServiceImpl implements IdentityService{

    public IdentityServiceImpl() {
    }

    @Override
    public Group newGroup(String groupId) {
        return (Group)this.commandExecutor.execute(new CreateGroupCmd(groupId));
    }

    @Override
    public User newUser(String userId) {
        return (User)this.commandExecutor.execute(new CreateUserCmd(userId));
    }

    @Override
    public void saveGroup(Group group) {
        this.commandExecutor.execute(new SaveGroupCmd((GroupEntity)group));
    }

    @Override
    public void saveUser(User user) {
        this.commandExecutor.execute(new SaveUserCmd(user));
    }

    @Override
    public UserQuery createUserQuery() {
        return (UserQuery)this.commandExecutor.execute(new CreateUserQueryCmd());
    }

    @Override
    public NativeUserQuery createNativeUserQuery() {
        return new NativeUserQueryImpl(this.commandExecutor);
    }

    @Override
    public GroupQuery createGroupQuery() {
        return (GroupQuery)this.commandExecutor.execute(new CreateGroupQueryCmd());
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        return new NativeGroupQueryImpl(this.commandExecutor);
    }

    @Override
    public void createMembership(String userId, String groupId) {
        this.commandExecutor.execute(new CreateMembershipCmd(userId, groupId));
    }

    @Override
    public void deleteGroup(String groupId) {
        this.commandExecutor.execute(new DeleteGroupCmd(groupId));
    }

    @Override
    public void deleteMembership(String userId, String groupId) {
        this.commandExecutor.execute(new DeleteMembershipCmd(userId, groupId));
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        return ((Boolean)this.commandExecutor.execute(new CheckPassword(userId, password))).booleanValue();
    }

    @Override
    public void deleteUser(String userId) {
        this.commandExecutor.execute(new DeleteUserCmd(userId));
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
        this.commandExecutor.execute(new SetUserPictureCmd(userId, picture));
    }

    @Override
    public Picture getUserPicture(String userId) {
        return (Picture)this.commandExecutor.execute(new GetUserPictureCmd(userId));
    }

    @Override
    public void setAuthenticatedUserId(String authenticatedUserId) {
        Authentication.setAuthenticatedUserId(authenticatedUserId);
    }

    @Override
    public String getUserInfo(String userId, String key) {
        return (String)this.commandExecutor.execute(new GetUserInfoCmd(userId, key));
    }

    @Override
    public List<String> getUserInfoKeys(String userId) {
        return (List)this.commandExecutor.execute(new GetUserInfoKeysCmd(userId, "userinfo"));
    }

    @Override
    public void setUserInfo(String userId, String key, String value) {
        this.commandExecutor.execute(new SetUserInfoCmd(userId, key, value));
    }

    @Override
    public void deleteUserInfo(String userId, String key) {
        this.commandExecutor.execute(new DeleteUserInfoCmd(userId, key));
    }
}
