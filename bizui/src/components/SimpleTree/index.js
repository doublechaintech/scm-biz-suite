import { Tree, Input } from 'antd';

const { Search } = Input;


const sampleListData=[{
  "name": "双链科技数据中台系统（DMOS)",
  "value": "双链科技数据中台系统（DMOS)",
  "key": "双链科技数据中台系统（DMOS)",
  "title": "双链科技数据中台系统（DMOS)",
  "children": [{
    "name": "platform",
    "value": "platform",
    "key": "platform",
    "title": "platform",
    "children": [{
      "name": "change_request_type",
      "value": "change_request_type",
      "key": "change_request_type",
      "title": "change_request_type",
      "children": [{
        "name": "change_request",
        "value": "change_request",
        "key": "change_request",
        "title": "change_request",
        "children": [{
          "name": "event",
          "value": "event",
          "key": "event",
          "title": "event",
          "children": [],
        }, {
          "name": "event1",
          "value": "event1",
          "key": "event1",
          "title": "event1",
          "children": [],
        }],
      }],
    }, {
      "name": "change_request",
      "value": "change_request",
      "key": "change_request",
      "title": "change_request",
      "children": [{
        "name": "event",
        "value": "event",
        "key": "event",
        "title": "event",
        "children": [],
      }, {
        "name": "event1",
        "value": "event1",
        "key": "event1",
        "title": "event1",
        "children": [],
      }],
    }, {
      "name": "chart_type",
      "value": "chart_type",
      "key": "chart_type",
      "title": "chart_type",
      "children": [{
        "name": "chart_page",
        "value": "chart_page",
        "key": "chart_page",
        "title": "chart_page",
        "children": [{
          "name": "chart",
          "value": "chart",
          "key": "chart",
          "title": "chart",
          "children": [],
        }],
      }, {
        "name": "chart",
        "value": "chart",
        "key": "chart",
        "title": "chart",
        "children": [],
      }],
    }, {
      "name": "user_status",
      "value": "user_status",
      "key": "user_status",
      "title": "user_status",
      "children": [{
        "name": "data_app_user",
        "value": "data_app_user",
        "key": "data_app_user",
        "title": "data_app_user",
        "children": [{
          "name": "data_application",
          "value": "data_application",
          "key": "data_application",
          "title": "data_application",
          "children": [{
            "name": "candidate_data_set",
            "value": "candidate_data_set",
            "key": "candidate_data_set",
            "title": "candidate_data_set",
            "children": [],
          }, {
            "name": "chart_page",
            "value": "chart_page",
            "key": "chart_page",
            "title": "chart_page",
            "children": [{
              "name": "chart",
              "value": "chart",
              "key": "chart",
              "title": "chart",
              "children": [],
            }],
          }, {
            "name": "chart",
            "value": "chart",
            "key": "chart",
            "title": "chart",
            "children": [],
          }],
        }],
      }],
    }, {
      "name": "data_app_user",
      "value": "data_app_user",
      "key": "data_app_user",
      "title": "data_app_user",
      "children": [{
        "name": "data_application",
        "value": "data_application",
        "key": "data_application",
        "title": "data_application",
        "children": [{
          "name": "candidate_data_set",
          "value": "candidate_data_set",
          "key": "candidate_data_set",
          "title": "candidate_data_set",
          "children": [],
        }, {
          "name": "chart_page",
          "value": "chart_page",
          "key": "chart_page",
          "title": "chart_page",
          "children": [{
            "name": "chart",
            "value": "chart",
            "key": "chart",
            "title": "chart",
            "children": [],
          }],
        }, {
          "name": "chart",
          "value": "chart",
          "key": "chart",
          "title": "chart",
          "children": [],
        }],
      }],
    }],
  }, {
    "name": "mobile_app",
    "value": "mobile_app",
    "key": "mobile_app",
    "title": "mobile_app",
    "children": [{
      "name": "page",
      "value": "page",
      "key": "page",
      "title": "page",
      "children": [{
        "name": "slide",
        "value": "slide",
        "key": "slide",
        "title": "slide",
        "children": [],
      }, {
        "name": "ui_action",
        "value": "ui_action",
        "key": "ui_action",
        "title": "ui_action",
        "children": [],
      }],
    }, {
      "name": "page_type",
      "value": "page_type",
      "key": "page_type",
      "title": "page_type",
      "children": [{
        "name": "page",
        "value": "page",
        "key": "page",
        "title": "page",
        "children": [{
          "name": "slide",
          "value": "slide",
          "key": "slide",
          "title": "slide",
          "children": [],
        }, {
          "name": "ui_action",
          "value": "ui_action",
          "key": "ui_action",
          "title": "ui_action",
          "children": [],
        }],
      }],
    }],
  }, {
    "name": "section",
    "value": "section",
    "key": "section",
    "title": "section",
    "children": [],
  }, {
    "name": "user_domain",
    "value": "user_domain",
    "key": "user_domain",
    "title": "user_domain",
    "children": [{
      "name": "user_white_list",
      "value": "user_white_list",
      "key": "user_white_list",
      "title": "user_white_list",
      "children": [],
    }, {
      "name": "sec_user",
      "value": "sec_user",
      "key": "sec_user",
      "title": "sec_user",
      "children": [{
        "name": "user_app",
        "value": "user_app",
        "key": "user_app",
        "title": "user_app",
        "children": [{
          "name": "quick_link",
          "value": "quick_link",
          "key": "quick_link",
          "title": "quick_link",
          "children": [],
        }, {
          "name": "list_access",
          "value": "list_access",
          "key": "list_access",
          "title": "list_access",
          "children": [],
        }, {
          "name": "object_access",
          "value": "object_access",
          "key": "object_access",
          "title": "object_access",
          "children": [],
        }],
      }, {
        "name": "login_history",
        "value": "login_history",
        "key": "login_history",
        "title": "login_history",
        "children": [],
      }, {
        "name": "wechat_workapp_identify",
        "value": "wechat_workapp_identify",
        "key": "wechat_workapp_identify",
        "title": "wechat_workapp_identify",
        "children": [],
      }, {
        "name": "wechat_miniapp_identify",
        "value": "wechat_miniapp_identify",
        "key": "wechat_miniapp_identify",
        "title": "wechat_miniapp_identify",
        "children": [],
      }, {
        "name": "keypair_identify",
        "value": "keypair_identify",
        "key": "keypair_identify",
        "title": "keypair_identify",
        "children": [],
      }],
    }, {
      "name": "public_key_type",
      "value": "public_key_type",
      "key": "public_key_type",
      "title": "public_key_type",
      "children": [{
        "name": "keypair_identify",
        "value": "keypair_identify",
        "key": "keypair_identify",
        "title": "keypair_identify",
        "children": [],
      }],
    }],
  }, {
    "name": "generic_form",
    "value": "generic_form",
    "key": "generic_form",
    "title": "generic_form",
    "children": [{
      "name": "form_message",
      "value": "form_message",
      "key": "form_message",
      "title": "form_message",
      "children": [],
    }, {
      "name": "form_field_message",
      "value": "form_field_message",
      "key": "form_field_message",
      "title": "form_field_message",
      "children": [],
    }, {
      "name": "form_field",
      "value": "form_field",
      "key": "form_field",
      "title": "form_field",
      "children": [],
    }, {
      "name": "form_action",
      "value": "form_action",
      "key": "form_action",
      "title": "form_action",
      "children": [],
    }],
  }, {
    "name": "candidate_container",
    "value": "candidate_container",
    "key": "candidate_container",
    "title": "candidate_container",
    "children": [{
      "name": "candidate_element",
      "value": "candidate_element",
      "key": "candidate_element",
      "title": "candidate_element",
      "children": [],
    }]
  }, {
    "name": "tree_node",
    "value": "tree_node",
    "key": "tree_node",
    "title": "tree_node",
    "children": [],
  }]
}]


const subList=(listData,searchValue)=>{
    console.log("subList", listData)
    return listData.filter(item=>item.name&&item.name.indexOf(searchValue)>=0)
}
const allKeys=(listData)=>{
    return listData.map(item=>item.id)
}

  


/*

 <TreeSearch className={styles.tableList} 
                            callbackFunction={callbackFunction}
                            callbackParameters={callbackParameters}
                        />

*/

export default class TreeSearch extends React.Component {
  state = {
    expandedKeys: [],
    searchValue: '',
    candidateValues:[],
    autoExpandParent: true,
  };

  componentDidMount() {
    this.mounted = true;
    const {callbackFunction,callbackParameters} = this.props
    if(!callbackFunction||!callbackParameters){
        return
    }
    const future = callbackFunction(callbackParameters)

    future.then(data=>{
        if(this.mounted){
            console.log("data==========>",data)
            const candidateValues=data
            this.setState({candidateValues,expandedKeys:allKeys(data)})
        }
    })

  }

  componentWillUnmount() {
    this.mounted = false;
  }

  onExpand = expandedKeys => {
    this.setState({
      expandedKeys,
      autoExpandParent: false,
    });
  };

  onChange = e => {
    const { value } = e.target;
    const {candidateValues} = this.state
    const expandedKeys = subList(candidateValues, value)
      .map(item => {
        
        return item.id;
      })
    this.setState({
      expandedKeys,
      searchValue: value,
      autoExpandParent: true,
    });
  };

  onSelect = (selectedKeys, info) => {
    console.log('selected', selectedKeys, info);
  };

  render() {
    const { searchValue, expandedKeys, autoExpandParent , candidateValues} = this.state;
    const {handleSelectNode} = this.props
    const  treeData = sampleListData
    const  onSelectNode = handleSelectNode || this.onSelect
    return (
      <div style={{marginRight:"10px", minHeight:'700px'}}>
       
        {(treeData.length>0)&&(<Tree
          defaultExpandAll
          onExpand={this.onExpand}
          expandedKeys={expandedKeys}
          autoExpandParent={autoExpandParent}
          onSelect={onSelectNode}
          treeData={treeData}
        />)}
        {treeData.lenth === 0&&(<div>请重新输入搜索条件</div>)}
      </div>
    );
  }
}

