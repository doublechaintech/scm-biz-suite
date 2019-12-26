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
const menuData = {menuName:"用户白名单", menuFor: "userWhiteList",
=======

const menuData = {menuName: window.trans('user_white_list'), menuFor: "userWhiteList",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"用户白名单", menuFor: "userWhiteList",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  userIdentity: '用户标识',
  userSpecialFunctions: '用户特殊功能',
  domain: '域',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'userWhiteList') , sorter: true },
  { title: fieldLabels.userIdentity, debugtype: 'string', dataIndex: 'userIdentity', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userSpecialFunctions, debugtype: 'string', dataIndex: 'userSpecialFunctions', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domain, dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(userWhiteList,targetComponent)=>{

  const userContext = null
  return (
    <div key={userWhiteList.id}>
	
      <DescriptionList  key={userWhiteList.id} size="small" col="4">
        <Description term="ID">{userWhiteList.id}</Description> 
        <Description term="用户标识">{userWhiteList.userIdentity}</Description> 
        <Description term="用户特殊功能">{userWhiteList.userSpecialFunctions}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {userIdentity, userSpecialFunctions, domainId} = formValuesToPack
	const domain = {id: domainId, version: 2^31}
	const data = {userIdentity, userSpecialFunctions, domain}
	return data
}
=======

const settingMenuData = {menuName: window.trans('user_white_list'), menuFor: "userWhiteList",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('user_white_list.id'),
  userIdentity: window.trans('user_white_list.user_identity'),
  userSpecialFunctions: window.trans('user_white_list.user_special_functions'),
  domain: window.trans('user_white_list.domain'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'userWhiteList') , sorter: true },
  { title: fieldLabels.userIdentity, debugtype: 'string', dataIndex: 'userIdentity', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userSpecialFunctions, debugtype: 'string', dataIndex: 'userSpecialFunctions', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domain, dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(userWhiteList,targetComponent)=>{

  const userContext = null
  return (
    <div key={userWhiteList.id}>
	
      <DescriptionList  key={userWhiteList.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{userWhiteList.id}</Description> 
        <Description term={fieldLabels.userIdentity} style={{wordBreak: 'break-all'}}>{userWhiteList.userIdentity}</Description> 
        <Description term={fieldLabels.userSpecialFunctions} style={{wordBreak: 'break-all'}}>{userWhiteList.userSpecialFunctions}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {userIdentity, userSpecialFunctions, domainId} = formValuesToPack
	const domain = {id: domainId, version: 2^31}
	const data = {userIdentity, userSpecialFunctions, domain}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {userIdentity, userSpecialFunctions, domain} = objectToUnpack
	const domainId = domain ? domain.id : null
	const data = {userIdentity, userSpecialFunctions, domainId}
	return data
}
<<<<<<< HEAD

const UserWhiteListBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const UserWhiteListBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default UserWhiteListBase



