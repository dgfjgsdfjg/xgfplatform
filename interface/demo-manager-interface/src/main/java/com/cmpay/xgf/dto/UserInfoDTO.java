package com.cmpay.xgf.dto;

public class UserInfoDTO {
        /**
         * @Fields uId 用户id
         */
        private Integer uId;
        /**
         * @Fields userName 用户名
         */
        private String username;

        /**
         * @Fields name 名字
         */
        private String name;

        /**
         * @Fields email 邮箱
         */
        private String email;
        /**
         * @Fields status 用户登陆状态
         */
        private Integer status;
        /**
         * @Fields phone 用户电话号码
         */
        private String phone;
        /**
         * @Fields roleId 角色Id
         */
        private Integer roleId;
        /**
         * @Fields createDate 创建日期
         */
        private String createDate;

        public Integer getuId() {
                return uId;
        }

        public void setuId(Integer uId) {
                this.uId = uId;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public Integer getRoleId() {
                return roleId;
        }

        public void setRoleId(Integer roleId) {
                this.roleId = roleId;
        }

        public String getCreateDate() {
                return createDate;
        }

        public void setCreateDate(String createDate) {
                this.createDate = createDate;
        }

}
