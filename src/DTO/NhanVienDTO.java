package DTO;

public class NhanVienDTO {
    private int id, roleGroupId;
    private String name, username, password, roleGroupName;
    private boolean status;

    public NhanVienDTO(int id, int roleGroupId, String name, String username, String password, String roleGroupName, boolean status) {
        this.id = id;
        this.roleGroupId = roleGroupId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleGroupName = roleGroupName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleGroupId() {
        return roleGroupId;
    }

    public void setRoleGroupId(int roleGroupId) {
        this.roleGroupId = roleGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleGroupName() {
        return roleGroupName;
    }

    public void setRoleGroupName(String roleGroupName) {
        this.roleGroupName = roleGroupName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, RoleGroup: %d, Name: %s, Username: %s, Password: %s, RoleGroupName: %s, Status: %b", id, roleGroupId, name, username, password, roleGroupName, status);
    }
}
