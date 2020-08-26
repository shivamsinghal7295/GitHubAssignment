package com.example.githubassignment;

import com.example.githubassignment.Models.Profile;
import com.example.githubassignment.Models.PublicRepository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseData {

    public static Profile parseProfileData(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        Profile profile = new Profile();

        if (jsonObject.has("login")){
            if (jsonObject.isNull("login")){
                profile.login = "";
            }else {
                profile.login = jsonObject.getString("login");
            }
        }else {
            profile.login = "";
        }

        if (jsonObject.has("id")){
            if (jsonObject.isNull("id")){
                profile.id = 0;
            }else {
                profile.id = jsonObject.getLong("id");
            }
        }else {
            profile.id = 0;
        }

        if (jsonObject.has("repos_url")){
            if (jsonObject.isNull("repos_url")){
                profile.repos_url = "";
            }else {
                profile.repos_url = jsonObject.getString("repos_url");
            }
        }else {
            profile.repos_url = "";
        }

        if (jsonObject.has("type")){
            if (jsonObject.isNull("type")){
                profile.type = "";
            }else {
                profile.type = jsonObject.getString("type");
            }
        }else {
            profile.type = "";
        }

        if (jsonObject.has("name")){
            if (jsonObject.isNull("name")){
                profile.name = "";
            }else {
                profile.name = jsonObject.getString("name");
            }
        }else {
            profile.name = "";
        }

        if (jsonObject.has("company")){
            if (jsonObject.isNull("company")){
                profile.company = "";
            }else {
                profile.company = jsonObject.getString("company");
            }
        }else {
            profile.company = "";
        }

        if (jsonObject.has("location")){
            if (jsonObject.isNull("location")){
                profile.location = "";
            }else {
                profile.location = jsonObject.getString("location");
            }
        }else {
            profile.location = "";
        }

        if (jsonObject.has("email")){
            if (jsonObject.isNull("email")){
                profile.email = "";
            }else {
                profile.email = jsonObject.getString("email");
            }
        }else {
            profile.email = "";
        }

        if (jsonObject.has("bio")){
            if (jsonObject.isNull("bio")){
                profile.bio = "";
            }else {
                profile.bio = jsonObject.getString("bio");
            }
        }else {
            profile.bio = "";
        }

        if (jsonObject.has("twitter_username")){
            if (jsonObject.isNull("twitter_username")){
                profile.twitter_username = "";
            }else {
                profile.twitter_username = jsonObject.getString("twitter_username");
            }
        }else {
            profile.twitter_username = "";
        }

        if (jsonObject.has("public_repos")){
            if (jsonObject.isNull("public_repos")){
                profile.public_repos = 0;
            }else {
                profile.public_repos = jsonObject.getInt("public_repos");
            }
        }else {
            profile.public_repos = 0;
        }

        if (jsonObject.has("followers")){
            if (jsonObject.isNull("followers")){
                profile.followers = 0;
            }else {
                profile.followers = jsonObject.getInt("followers");
            }
        }else {
            profile.followers = 0;
        }

        if (jsonObject.has("total_private_repos")){
            if (jsonObject.isNull("total_private_repos")){
                profile.total_private_repos = 0;
            }else {
                profile.total_private_repos = jsonObject.getInt("total_private_repos");
            }
        }else {
            profile.total_private_repos = 0;
        }


        return profile;

    }

    public static List<PublicRepository> parseRepositoryResponse(String response) throws JSONException {

        List<PublicRepository> list = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(response);

        if (jsonArray.length() > 0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                PublicRepository publicRepository = new PublicRepository();


                if (jsonObject.has("full_name")) {
                    if (jsonObject.isNull("full_name")) {
                        publicRepository.full_name = "";
                    } else {
                        publicRepository.full_name = jsonObject.getString("full_name");
                    }
                } else {
                    publicRepository.full_name = "";
                }

                if (jsonObject.has("id")) {
                    if (jsonObject.isNull("id")) {
                        publicRepository.id = 0;
                    } else {
                        publicRepository.id = jsonObject.getLong("id");
                    }
                } else {
                    publicRepository.id = 0;
                }

                if (jsonObject.has("language")) {
                    if (jsonObject.isNull("language")) {
                        publicRepository.language = "";
                    } else {
                        publicRepository.language = jsonObject.getString("language");
                    }
                } else {
                    publicRepository.language = "";
                }

                if (jsonObject.has("watchers_count")) {
                    if (jsonObject.isNull("watchers_count")) {
                        publicRepository.watchers_count = 0;
                    } else {
                        publicRepository.watchers_count = jsonObject.getInt("watchers_count");
                    }
                } else {
                    publicRepository.watchers_count = 0;
                }

                if (jsonObject.has("name")) {
                    if (jsonObject.isNull("name")) {
                        publicRepository.name = "";
                    } else {
                        publicRepository.name = jsonObject.getString("name");
                    }
                } else {
                    publicRepository.name = "";
                }

                if (jsonObject.has("open_issues")) {
                    if (jsonObject.isNull("open_issues")) {
                        publicRepository.open_issues = 0;
                    } else {
                        publicRepository.open_issues = jsonObject.getInt("open_issues");
                    }
                } else {
                    publicRepository.open_issues = 0;
                }

                if (jsonObject.has("default_branch")) {
                    if (jsonObject.isNull("default_branch")) {
                        publicRepository.default_branch = "";
                    } else {
                        publicRepository.default_branch = jsonObject.getString("default_branch");
                    }
                } else {
                    publicRepository.default_branch = "";
                }

                list.add(publicRepository);
            }

        }


        return list;

    }
}
