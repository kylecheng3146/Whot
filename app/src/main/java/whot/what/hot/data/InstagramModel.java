package whot.what.hot.data;

/**
 * Created by Kevin on 2018/2/5.
 */

public class InstagramModel {


    /**
     * data : {"id":"315272341","username":"kai_cheng","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","full_name":"鄭凱凱✨","bio":"💕 kaikai 👫 chab ❣","website":"http://www.facebook.com/kai0406","is_business":false,"counts":{"media":221,"follows":307,"followed_by":323}}
     * meta : {"code":200}
     */

    private DataBean data;
    private MetaBean meta;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public static class DataBean {
        /**
         * id : 315272341
         * username : kai_cheng
         * profile_picture : https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg
         * full_name : 鄭凱凱✨
         * bio : 💕 kaikai 👫 chab ❣
         * website : http://www.facebook.com/kai0406
         * is_business : false
         * counts : {"media":221,"follows":307,"followed_by":323}
         */

        private String id;
        private String username;
        private String profile_picture;
        private String full_name;
        private String bio;
        private String website;
        private boolean is_business;
        private CountsBean counts;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getProfile_picture() {
            return profile_picture;
        }

        public void setProfile_picture(String profile_picture) {
            this.profile_picture = profile_picture;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public boolean isIs_business() {
            return is_business;
        }

        public void setIs_business(boolean is_business) {
            this.is_business = is_business;
        }

        public CountsBean getCounts() {
            return counts;
        }

        public void setCounts(CountsBean counts) {
            this.counts = counts;
        }

        public static class CountsBean {
            /**
             * media : 221
             * follows : 307
             * followed_by : 323
             */

            private int media;
            private int follows;
            private int followed_by;

            public int getMedia() {
                return media;
            }

            public void setMedia(int media) {
                this.media = media;
            }

            public int getFollows() {
                return follows;
            }

            public void setFollows(int follows) {
                this.follows = follows;
            }

            public int getFollowed_by() {
                return followed_by;
            }

            public void setFollowed_by(int followed_by) {
                this.followed_by = followed_by;
            }
        }
    }

    public static class MetaBean {
        /**
         * code : 200
         */

        private int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
