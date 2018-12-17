
import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import { notification } from 'antd'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown, Badge, Switch, Select, Form, AutoComplete, Modal } from 'antd'
import { Link, Route, Redirect } from 'dva/router'
import numeral from 'numeral'
import {
    ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../components/Charts'
import Trend from '../components/Trend'
import NumberInfo from '../components/NumberInfo'
import { getTimeDistance } from '../utils/utils'
import PageHeaderLayout from '../layouts/PageHeaderLayout'
import styles from './PermissionSetting.less'
import DescriptionList from '../components/DescriptionList';
import ImagePreview from '../components/ImagePreview';
import GlobalComponents from '../custcomponents';
import { Checkbox } from 'antd';
import PermissionSettingService from './PermissionSetting.service'
const CheckboxGroup = Checkbox.Group;
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


//////////////////////////////开始权限的代码//////////////////////////



const  onChange =  (checked)  =>{
    console.log(`switch to ${checked}`);
  }

const  onListAccessChange =  (value, targetComponent)  =>{

  const {selectedApp}=targetComponent.state
  const {selectedUser}=targetComponent.state
 
    if(selectedUser.length<5){
      notification.error({
        message: "错误",
        description: "请选择要操作的用户",
      })
      return;
    }

    const {id,version} = selectedApp;

    const future = PermissionSettingService.updateListAccess(
      selectedUser,
      id,"测试",
      value.join()
    )

    future.then(app => {
      console.log("app",app);
      targetComponent.setState({
        selectedApp: app,
      })
    })

    console.log(`switch to ${value}`)
  }
  const  onGroupChange =  (value,targetComponent)  =>{
    console.log(`switched to ${value.length}`)

    const {selectedApp}=targetComponent.state
    const {selectedUser}=targetComponent.state
    
    if(selectedUser.length<5){
      notification.error({
        message: "错误",
        description: "请选择要操作的用户",
      })
      return;
    }

    const {id,version} = selectedApp;
    


    //const newSelectedApp = {...selectedApp,permission: value.join('')}

    const future = PermissionSettingService.updateAppPermission(
      selectedUser,
      id,version,
      value.join('')
    )
    
    future.then(app => {
      console.log("app",app);
      targetComponent.setState({
        selectedApp: app,
      });
    });  
    

  }

  const  onSelectUser = (targetUser,targetComponent) =>{
    console.log(`switch to ${targetUser}`);
    const objectType = targetComponent.props.targetObjectMeta.menuData.menuFor;
    const objectId = targetComponent.props.targetObject.id
    const title = targetComponent.props.targetObject.displayName
    const appIcon = 'app'//targetComponent.props.targetObjectMeta.menuData.
    console.log(`switch to ${targetComponent}`);
    const future = PermissionSettingService.loadUserAppWithUser(
      targetUser,
      objectType,objectId,title,appIcon      
    );
    console.log(future);

    future.then(app => {
      console.log("app",app);
      targetComponent.setState({
        selectedApp: app,
        selectedUser: targetUser
      });
    });



  }

  const renderBooleanCell=(value, record,index)=>{
      //return  (value? '是' : '否')
    return (<Checkbox value={`${record.name}.${index}`} />)
  }
  const rendeEnableAllCell=(value, record)=>{
  
      //return  (value? '是' : '否')
    return (<Switch checkedChildren="是" unCheckedChildren="否" defaultChecked={value} onChange={onChange}/>)
  }
  
  
  const columns = [{
    title: '列表名称',
    dataIndex: 'displayName',
    key: 'name',
  }, {
    title: '读取权限',
    dataIndex: 'readPermission',
    key: 'readPermission',
    render: (text, record, index) =>renderBooleanCell(text, record,'readPermission')
  }, {
    title: '新增权限',
    dataIndex: 'createPermission',
    key: 'createPermission',
  
    render: (text, record, index) =>renderBooleanCell(text, record, 'createPermission')
  },{
    title: '删除权限',
    dataIndex: 'deletePermission',
    key: 'deletePermission',
    render: (text, record, index) =>renderBooleanCell(text, record,'deletePermission')
  },{
    title: '更新权限',
    dataIndex: 'updatePermission',
    key: 'updatePermission',
    render: (text, record, index) =>renderBooleanCell(text, record,'updatePermission')
  },{
    title: '执行权限',
    dataIndex: 'executionPermission',
    key: 'executionPermission',
    render: (text, record, index) =>renderBooleanCell(text, record,'executionPermission')
  }];
  
  /*
  
  const menuData = {menuName:"平台", menuFor: "platform",
            subItems: [
    {name: 'mailList', displayName:'邮件', icon:'mail-bulk',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executePermission: false},
    {name: 'errorLogList', displayName:'错误日志', icon:'blogger',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executePermission: false},
    
            ],
  }
  
  */
  
  const permissions=[
    {name:"管理权限",code: "M"},
    {name:"写入权限",code: "W"},
    {name:"读取权限",code: "R",default:true},
    {name:"执行权限",code: "X"},
  
  
  ]
  
  const renderTableHeader =(targetComponent)=>{
  
   
    const {candidateUsers,selectedApp} = targetComponent.state;
    const values = selectedApp.permission?selectedApp.permission.split(''):[]
    console.log("values", values)

    return (<Checkbox.Group style={{ width: '100%' }} value={values} onChange={(value)=>onGroupChange(value, targetComponent)}>
    <label className={styles.permissinWithTitle}>请选择用户</label>
    <AutoComplete className={styles.selectUser} dataSource={candidateUsers} 
      onSearch={(value)=>handleCandidateSecUserSearch(value,targetComponent)}
      onSelect={(value)=>onSelectUser(value,targetComponent)}>
    {candidateUsers.map(item=>{
                return (<Option key={item.id}>{`${item.id} - ${item.displayName}`}</Option>);
            })}
      </AutoComplete>


    <label className={styles.permissinWithTitle}>本级目标权限</label>
    {
      
      permissions.map((item)=>(
        <Checkbox key={item.name} value={item.code}>{item.name}</Checkbox>
       
      ))
  
      }
      
      </Checkbox.Group>)
  
  }
  
  const calcPresentData = (target)=>{
    const {menuData,selectedApp} = target

    const {listAccessList} = selectedApp
    const {subItems} = menuData
    if(!listAccessList){
      return subItems
    }
    console.log("listaccesslist", listAccessList)
    return subItems.map(item=>{
      var storedItem = listAccessList.find((anotherItem)=>anotherItem.internalName==item.name)
      console.log("storedItem", storedItem)
      if(storedItem){
        
        return {...storedItem,displayName:item.displayName, name:storedItem.internalName}
      }
      return item

    })
     


  }
  const calcCheckValues = (target)=>{
    const {menuData,selectedApp} = target

    const {listAccessList} = selectedApp
    const {subItems} = menuData
    if(!listAccessList){
      return []
    }
    console.log("listaccesslist", listAccessList)
    const finalValues = []

    listAccessList.map(item=>{
      if(item.readPermission){
        finalValues.push(item.internalName+".readPermission")
      }
      if(item.createPermission){
        finalValues.push(item.internalName+".createPermission")
      }
      if(item.updatePermission){
        finalValues.push(item.internalName+".updatePermission")
      }
      if(item.deletePermission){
        finalValues.push(item.internalName+".deletePermission")
      }
      if(item.executionPermission){
        finalValues.push(item.internalName+".executionPermission")
      }

    })
    
    return finalValues


  }
  const renderPermissionHeader = (targetComponent)=> {
   

    if(!targetComponent.state.managementAccess){
      return null
    }

    const {targetObject,targetObjectMeta} = targetComponent.props
    const targetId = targetObject.id
    const {menuData} = targetObjectMeta
    //const {subItems} = menuData
    
    const {selectedApp} = targetComponent.state

    const calcedData = calcPresentData({menuData,selectedApp})
    const calcedValues = calcCheckValues({menuData,selectedApp})
    return (
  
     
          <Card title={`${menuData.menuName}(${targetId}）权限设置`} className={styles.card}>
         <Checkbox.Group onChange={(value)=>onListAccessChange(value,targetComponent)} style={{ width: '100%' }} value={calcedValues}>
         <Table title={() =>renderTableHeader(targetComponent) } 
         rowKey={record => record.name}
         dataSource={calcedData} columns={columns} pagination={false}/>
         </Checkbox.Group>
         </Card>
        
      )
  }

  
  const loadInitialData = (targetComponent) => {


    const objectType = targetComponent.props.targetObjectMeta.menuData.menuFor;
    const objectId = targetComponent.props.targetObject.id

    const future = PermissionSettingService.testIfHasManagementAccess(objectType,objectId)

    future.then(testResult => {
     
      if(testResult=="OK"){
        executeCandidateSecUserSearch("",targetComponent)
        return
      }

      targetComponent.setState({
        managementAccess: false,
      });

    });



  }


  const executeCandidateSecUserSearch = (filterKey,targetComponent) => {
  

    const id = ''; //not used for now
    const pageNo = 1;
    const future = PermissionSettingService.requestCandidateSecUser(
      '',
      id,
      filterKey,
      pageNo
    );
    console.log(future);

    future.then(candidateUsersResponse => {
      console.log("candidateUsersResponse",candidateUsersResponse);
      targetComponent.setState({
        candidateUsers: candidateUsersResponse.candidates,
        managementAccess:true
      });
    });
  };


  const handleCandidateSecUserSearch = (value,targetComponent) => {
    console.log("calling search for ", value)
    executeCandidateSecUserSearch(value,targetComponent);
  };



//PermissionSettingService
class PermissionTable extends Component {
  state = {
    candidateUsers: [], //start, inputvcode, changepass
    selectedUser: "",
    selectedApp:{},

  }

  componentDidMount() {
    // const { getFieldDecorator,setFieldsValue } = this.props.form
    
    //setFieldsValue(testValues)
    loadInitialData(this)
    
  }



  render() {
    const { targetObjectMeta, targetObject } = this.props



    console.log("targetObjectMeta",targetObjectMeta)
    return renderPermissionHeader(this)

  }


}
export default PermissionTable



