package whot.what.hot.data;

import java.util.List;

/** Instagram API
 * Created by Kevin on 2018/2/6.
 */

public class InstagramTagModel {

    /**
     * pagination : {"next_min_id":"AQCsfSI7e2bbb4el3OAEChUavKqVZljJzh0imHbg02IWw9DhoUnsnLyMKeleJVFmXcYhEdt6mDVSQpmZ0K17KNeSkduo1b0U42DyF1S1Qx1bKg","min_tag_id":"AQCsfSI7e2bbb4el3OAEChUavKqVZljJzh0imHbg02IWw9DhoUnsnLyMKeleJVFmXcYhEdt6mDVSQpmZ0K17KNeSkduo1b0U42DyF1S1Qx1bKg","deprecation_warning":"next_max_id and min_id are deprecated for this endpoint; use min_tag_id and max_tag_id instead"}
     * data : [{"id":"1703785597812807355_315272341","user":{"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/2686532 8_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"},"images":{"thumbnail":{"width":150,"height":150,"url":"https://scontent.cdninstagram.com/vp/e63cce972addbcc4c06ef311da1035d7/5B0052F1/t51.2885-15/s150x150/e35/c135.0.810.810/26867776_2000405200226676_3797664964215308288_n.jpg"},"low_resolution":{"width":320,"height":240,"url":"https://scontent.cdninstagram.com/vp/434b7d54bf2b1db44ec9c2fb16182f24/5B115087/t51.2885-15/s320x320/e35/26867776_2000405200226676_3797664964215308288_n.jpg"},"standard_resolution":{"width":640,"height":480,"url":"https://scontent.cdninstagram.com/vp/570c9c14dd60447dd4174c32fe1e8a41/5B2526CA/t51.2885-15/s640x640/sh0.08/e35/26867776_2000405200226676_3797664964215308288_n.jpg"}},"created_time":"1517327092","caption":{"id":"17912766691073309","text":"Sunset 🌇\n#tainan #taiwan #anping #landscape","created_time":"1517327092","from":{"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"}},"user_has_liked":false,"likes":{"count":23},"tags":["tainan","landscape","taiwan","anping"],"filter":"Normal","comments":{"count":0},"type":"image","link":"https://www.instagram.com/p/BelD_ljDxa7/","location":{"latitude":22.9971809,"longitude":120.2019806,"name":"淳鳩一夫拉麵","id":774290892},"attribution":null,"users_in_photo":[]},{"id":"1630393278288343877_315272341","user":{"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"},"images":{"thumbnail":{"width":150,"height":150,"url":"https://scontent.cdninstagram.com/vp/a07fe45a66ab4e93354de47c915f15c3/5B1EA530/t51.2885-15/s150x150/e35/c135.0.810.810/22639379_1808310132802051_1840508677358878720_n.jpg"},"low_resolution":{"width":320,"height":240,"url":"https://scontent.cdninstagram.com/vp/28145c39ba82f24bcbbb15c39dce996e/5B0D0F46/t51.2885-15/s320x320/e35/22639379_1808310132802051_1840508677358878720_n.jpg"},"standard_resolution":{"width":640,"height":480,"url":"https://scontent.cdninstagram.com/vp/bc91d74a1b5dfb8efc669c6fea9888b6/5B065D0B/t51.2885-15/s640x640/sh0.08/e35/22639379_1808310132802051_1840508677358878720_n.jpg"}},"created_time":"1508578046","caption":{"id":"17904502606048718","text":"喜歡這氛圍🍜🍜🍜\n#拉麵 #tainan #台南","created_time":"1508578046","from":{"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"}},"user_has_liked":true,"likes":{"count":23},"tags":["tainan","拉麵","台南"],"filter":"Normal","comments":{"count":2},"type":"image","link":"https://www.instagram.com/p/BagUgxkj7NF/","location":{"latitude":22.9971809,"longitude":120.2019806,"name":"淳鳩一夫拉麵","id":774290892},"attribution":null,"users_in_photo":[]},{"id":"1630362791737969179_315272341","user":{"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"},"images":{"thumbnail":{"width":150,"height":150,"url":"https://scontent.cdninstagram.com/vp/28d84e1ad798782a87407e880f430a55/5B12DE86/t51.2885-15/s150x150/e35/22637049_332544447210037_7782115822750662656_n.jpg"},"low_resolution":{"width":320,"height":320,"url":"https://scontent.cdninstagram.com/vp/97d902609a1ddf09bcbeb85401fc2932/5B1DF8C1/t51.2885-15/s320x320/e35/22637049_332544447210037_7782115822750662656_n.jpg"},"standard_resolution":{"width":640,"height":640,"url":"https://scontent.cdninstagram.com/vp/332ddfd0236b9c5a8a79fb8d53bfb5ce/5B071782/t51.2885-15/s640x640/sh0.08/e35/22637049_332544447210037_7782115822750662656_n.jpg"}},"created_time":"1508574411","caption":{"id":"17903594791023082","text":"🙏🙏🙏\n#台南 #tainan #temple #culture","created_time":"1508574411","from":{"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"}},"user_has_liked":false,"likes":{"count":24},"tags":["台南","temple","tainan","culture"],"filter":"Lark","comments":{"count":0},"type":"image","link":"https://www.instagram.com/p/BagNlIwjkob/","location":{"latitude":22.9971809,"longitude":120.2019806,"name":"淳鳩一夫拉麵","id":774290892},"attribution":null,"users_in_photo":[]}]
     * meta : {"code":200}
     */

    private PaginationBean pagination;
    private MetaBean meta;
    private List<DataBean> data;

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PaginationBean {
        /**
         * next_min_id : AQCsfSI7e2bbb4el3OAEChUavKqVZljJzh0imHbg02IWw9DhoUnsnLyMKeleJVFmXcYhEdt6mDVSQpmZ0K17KNeSkduo1b0U42DyF1S1Qx1bKg
         * min_tag_id : AQCsfSI7e2bbb4el3OAEChUavKqVZljJzh0imHbg02IWw9DhoUnsnLyMKeleJVFmXcYhEdt6mDVSQpmZ0K17KNeSkduo1b0U42DyF1S1Qx1bKg
         * deprecation_warning : next_max_id and min_id are deprecated for this endpoint; use min_tag_id and max_tag_id instead
         */

        private String next_min_id;
        private String min_tag_id;
        private String deprecation_warning;

        public String getNext_min_id() {
            return next_min_id;
        }

        public void setNext_min_id(String next_min_id) {
            this.next_min_id = next_min_id;
        }

        public String getMin_tag_id() {
            return min_tag_id;
        }

        public void setMin_tag_id(String min_tag_id) {
            this.min_tag_id = min_tag_id;
        }

        public String getDeprecation_warning() {
            return deprecation_warning;
        }

        public void setDeprecation_warning(String deprecation_warning) {
            this.deprecation_warning = deprecation_warning;
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

    public static class DataBean {
        /**
         * id : 1703785597812807355_315272341
         * user : {"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/2686532 8_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"}
         * images : {"thumbnail":{"width":150,"height":150,"url":"https://scontent.cdninstagram.com/vp/e63cce972addbcc4c06ef311da1035d7/5B0052F1/t51.2885-15/s150x150/e35/c135.0.810.810/26867776_2000405200226676_3797664964215308288_n.jpg"},"low_resolution":{"width":320,"height":240,"url":"https://scontent.cdninstagram.com/vp/434b7d54bf2b1db44ec9c2fb16182f24/5B115087/t51.2885-15/s320x320/e35/26867776_2000405200226676_3797664964215308288_n.jpg"},"standard_resolution":{"width":640,"height":480,"url":"https://scontent.cdninstagram.com/vp/570c9c14dd60447dd4174c32fe1e8a41/5B2526CA/t51.2885-15/s640x640/sh0.08/e35/26867776_2000405200226676_3797664964215308288_n.jpg"}}
         * created_time : 1517327092
         * caption : {"id":"17912766691073309","text":"Sunset 🌇\n#tainan #taiwan #anping #landscape","created_time":"1517327092","from":{"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"}}
         * user_has_liked : false
         * likes : {"count":23}
         * tags : ["tainan","landscape","taiwan","anping"]
         * filter : Normal
         * comments : {"count":0}
         * type : image
         * link : https://www.instagram.com/p/BelD_ljDxa7/
         * location : {"latitude":22.9971809,"longitude":120.2019806,"name":"淳鳩一夫拉麵","id":774290892}
         * attribution : null
         * users_in_photo : []
         */

        private String id;
        private UserBean user;
        private ImagesBean images;
        private String created_time;
        private CaptionBean caption;
        private boolean user_has_liked;
        private LikesBean likes;
        private String filter;
        private CommentsBean comments;
        private String type;
        private String link;
        private LocationBean location;
        private Object attribution;
        private List<String> tags;
        private List<?> users_in_photo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public CaptionBean getCaption() {
            return caption;
        }

        public void setCaption(CaptionBean caption) {
            this.caption = caption;
        }

        public boolean isUser_has_liked() {
            return user_has_liked;
        }

        public void setUser_has_liked(boolean user_has_liked) {
            this.user_has_liked = user_has_liked;
        }

        public LikesBean getLikes() {
            return likes;
        }

        public void setLikes(LikesBean likes) {
            this.likes = likes;
        }

        public String getFilter() {
            return filter;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }

        public CommentsBean getComments() {
            return comments;
        }

        public void setComments(CommentsBean comments) {
            this.comments = comments;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public Object getAttribution() {
            return attribution;
        }

        public void setAttribution(Object attribution) {
            this.attribution = attribution;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<?> getUsers_in_photo() {
            return users_in_photo;
        }

        public void setUsers_in_photo(List<?> users_in_photo) {
            this.users_in_photo = users_in_photo;
        }

        public static class UserBean {
            /**
             * id : 315272341
             * full_name : 鄭凱凱✨
             * profile_picture : https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/2686532 8_234638280412399_6507396759390519296_n.jpg
             * username : kai_cheng
             */

            private String id;
            private String full_name;
            private String profile_picture;
            private String username;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFull_name() {
                return full_name;
            }

            public void setFull_name(String full_name) {
                this.full_name = full_name;
            }

            public String getProfile_picture() {
                return profile_picture;
            }

            public void setProfile_picture(String profile_picture) {
                this.profile_picture = profile_picture;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

        public static class ImagesBean {
            /**
             * thumbnail : {"width":150,"height":150,"url":"https://scontent.cdninstagram.com/vp/e63cce972addbcc4c06ef311da1035d7/5B0052F1/t51.2885-15/s150x150/e35/c135.0.810.810/26867776_2000405200226676_3797664964215308288_n.jpg"}
             * low_resolution : {"width":320,"height":240,"url":"https://scontent.cdninstagram.com/vp/434b7d54bf2b1db44ec9c2fb16182f24/5B115087/t51.2885-15/s320x320/e35/26867776_2000405200226676_3797664964215308288_n.jpg"}
             * standard_resolution : {"width":640,"height":480,"url":"https://scontent.cdninstagram.com/vp/570c9c14dd60447dd4174c32fe1e8a41/5B2526CA/t51.2885-15/s640x640/sh0.08/e35/26867776_2000405200226676_3797664964215308288_n.jpg"}
             */

            private ThumbnailBean thumbnail;
            private LowResolutionBean low_resolution;
            private StandardResolutionBean standard_resolution;

            public ThumbnailBean getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(ThumbnailBean thumbnail) {
                this.thumbnail = thumbnail;
            }

            public LowResolutionBean getLow_resolution() {
                return low_resolution;
            }

            public void setLow_resolution(LowResolutionBean low_resolution) {
                this.low_resolution = low_resolution;
            }

            public StandardResolutionBean getStandard_resolution() {
                return standard_resolution;
            }

            public void setStandard_resolution(StandardResolutionBean standard_resolution) {
                this.standard_resolution = standard_resolution;
            }

            public static class ThumbnailBean {
                /**
                 * width : 150
                 * height : 150
                 * url : https://scontent.cdninstagram.com/vp/e63cce972addbcc4c06ef311da1035d7/5B0052F1/t51.2885-15/s150x150/e35/c135.0.810.810/26867776_2000405200226676_3797664964215308288_n.jpg
                 */

                private int width;
                private int height;
                private String url;

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class LowResolutionBean {
                /**
                 * width : 320
                 * height : 240
                 * url : https://scontent.cdninstagram.com/vp/434b7d54bf2b1db44ec9c2fb16182f24/5B115087/t51.2885-15/s320x320/e35/26867776_2000405200226676_3797664964215308288_n.jpg
                 */

                private int width;
                private int height;
                private String url;

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class StandardResolutionBean {
                /**
                 * width : 640
                 * height : 480
                 * url : https://scontent.cdninstagram.com/vp/570c9c14dd60447dd4174c32fe1e8a41/5B2526CA/t51.2885-15/s640x640/sh0.08/e35/26867776_2000405200226676_3797664964215308288_n.jpg
                 */

                private int width;
                private int height;
                private String url;

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class CaptionBean {
            /**
             * id : 17912766691073309
             * text : Sunset 🌇
             #tainan #taiwan #anping #landscape
             * created_time : 1517327092
             * from : {"id":"315272341","full_name":"鄭凱凱✨","profile_picture":"https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg","username":"kai_cheng"}
             */

            private String id;
            private String text;
            private String created_time;
            private FromBean from;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getCreated_time() {
                return created_time;
            }

            public void setCreated_time(String created_time) {
                this.created_time = created_time;
            }

            public FromBean getFrom() {
                return from;
            }

            public void setFrom(FromBean from) {
                this.from = from;
            }

            public static class FromBean {
                /**
                 * id : 315272341
                 * full_name : 鄭凱凱✨
                 * profile_picture : https://scontent.cdninstagram.com/vp/2469451781a24668f22fa7410f0ff4a2/5B2564F7/t51.2885-19/s150x150/26865328_234638280412399_6507396759390519296_n.jpg
                 * username : kai_cheng
                 */

                private String id;
                private String full_name;
                private String profile_picture;
                private String username;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getFull_name() {
                    return full_name;
                }

                public void setFull_name(String full_name) {
                    this.full_name = full_name;
                }

                public String getProfile_picture() {
                    return profile_picture;
                }

                public void setProfile_picture(String profile_picture) {
                    this.profile_picture = profile_picture;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }
            }
        }

        public static class LikesBean {
            /**
             * count : 23
             */

            private int count;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static class CommentsBean {
            /**
             * count : 0
             */

            private int count;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static class LocationBean {
            /**
             * latitude : 22.9971809
             * longitude : 120.2019806
             * name : 淳鳩一夫拉麵
             * id : 774290892
             */

            private double latitude;
            private double longitude;
            private String name;
            private int id;

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
