import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"登录历史", menuFor: "loginHistory",
=======

const menuData = {menuName: window.trans('login_history'), menuFor: "loginHistory",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"登录历史", menuFor: "loginHistory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  loginTime: '登录时间',
  fromIp: '来自IP',
  description: '描述',
  secUser: '安全用户',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'loginHistory') , sorter: true },
  { title: fieldLabels.loginTime, dataIndex: 'loginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.fromIp, debugtype: 'string', dataIndex: 'fromIp', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.secUser, dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(loginHistory,targetComponent)=>{

  const userContext = null
  return (
    <div key={loginHistory.id}>
	
      <DescriptionList  key={loginHistory.id} size="small" col="4">
        <Description term="ID">{loginHistory.id}</Description> 
        <Description term="登录时间"><div>{ moment(loginHistory.loginTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="来自IP">{loginHistory.fromIp}</Description> 
        <Description term="描述">{loginHistory.description}</Description> 
        <Description term="安全用户"><div>{loginHistory.secUser==null?appLocaleName(userContext,"NotAssigned"):`${loginHistory.secUser.displayName}(${loginHistory.secUser.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {fromIp, description, secUserId} = formValuesToPack
	const secUser = {id: secUserId, version: 2^31}
	const data = {fromIp, description, secUser}
	return data
}
=======

const settingMenuData = {menuName: window.trans('login_history'), menuFor: "loginHistory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('login_history.id'),
  loginTime: window.trans('login_history.login_time'),
  fromIp: window.trans('login_history.from_ip'),
  description: window.trans('login_history.description'),
  secUser: window.trans('login_history.sec_user'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'loginHistory') , sorter: true },
  { title: fieldLabels.loginTime, dataIndex: 'loginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.fromIp, debugtype: 'string', dataIndex: 'fromIp', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.secUser, dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(loginHistory,targetComponent)=>{

  const userContext = null
  return (
    <div key={loginHistory.id}>
	
      <DescriptionList  key={loginHistory.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{loginHistory.id}</Description> 
        <Description term={fieldLabels.loginTime}><div>{ moment(loginHistory.loginTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.fromIp} style={{wordBreak: 'break-all'}}>{loginHistory.fromIp}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{loginHistory.description}</Description> 
        <Description term={fieldLabels.secUser}><div>{loginHistory.secUser==null?appLocaleName(userContext,"NotAssigned"):`${loginHistory.secUser.displayName}(${loginHistory.secUser.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {fromIp, description, secUserId} = formValuesToPack
	const secUser = {id: secUserId, version: 2^31}
	const data = {fromIp, description, secUser}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {fromIp, description, secUser} = objectToUnpack
	const secUserId = secUser ? secUser.id : null
	const data = {fromIp, description, secUserId}
	return data
}
<<<<<<< HEAD

const LoginHistoryBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const LoginHistoryBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default LoginHistoryBase



