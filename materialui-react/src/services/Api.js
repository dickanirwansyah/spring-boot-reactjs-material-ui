import axios from 'axios';

const BASE_API_LEADS = "http://localhost:7777/api/leads";
const PARAMS_LIST_LEADS = "/list-leads";
const PARAMS_LIST_ALL = "/list-all";
const PARAMS_LIST_ACTIVE = "/list-active";
const PARAMS_LIST_NOTACTIVE = "/list-notactive";
const PARAMS_ACTION_SAVE = "/action/save";
const PARAMS_ACTION_UPDATE = "/action/update";

class Api {

    //get
    sendGetRequest(endpoint, needAuth = false, params = null){
        let header = {
            Accept: 'application/json'
        };

        if (needAuth){
            console.log(needAuth)
        }

        let response = axios.get(endpoint, {
            headers: header, 
            params: params, 
            cancelToken: null
        });

        return response;
    }

    //post
    sendPostRequest(endpoint, needAuth = false, body){
        let header = {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        };

        if (needAuth){
            console.log(needAuth)
        }

        let response = axios.post(endpoint, JSON.stringify(body), {
            headers: header,
            cancelToken: null
        })

        return response;
    }

    //delete
    sendDeleteRequest(endpoint, needAuth = false, params = null){
        let header = {
            Accept: 'application/json'
        };

        if (needAuth){
            console.log(needAuth)
        }

        let response = axios.delete(endpoint, {
            headers: header,
            params: params,
            cancelToken: null
        })

        return response;
    }

    //list-leads/list-all
    fetchLeads(){
        return axios.get(BASE_API_LEADS+PARAMS_LIST_LEADS+PARAMS_LIST_ALL)
    }
}

export default new Api();