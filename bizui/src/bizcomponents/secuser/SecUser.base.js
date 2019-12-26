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
const menuData = {menuName:"安全用户", menuFor: "secUser",
  		subItems: [
  {name: 'userAppList', displayName:'用户应用程序', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'loginHistoryList', displayName:'登录历史', icon:'history',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('sec_user'), menuFor: "secUser",
  		subItems: [
  {name: 'userAppList', displayName: window.mtrans('user_app','sec_user.user_app_list',false), type:'userApp',icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'loginHistoryList', displayName: window.mtrans('login_history','sec_user.login_history_list',false), type:'loginHistory',icon:'history',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('sec_user'), menuFor: "secUser",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('sec_user.id'),
  login: window.trans('sec_user.login'),
  mobile: window.trans('sec_user.mobile'),
  email: window.trans('sec_user.email'),
  pwd: window.trans('sec_user.pwd'),
  weixinOpenid: window.trans('sec_user.weixin_openid'),
  weixinAppid: window.trans('sec_user.weixin_appid'),
  accessToken: window.trans('sec_user.access_token'),
  verificationCode: window.trans('sec_user.verification_code'),
  verificationCodeExpire: window.trans('sec_user.verification_code_expire'),
  lastLoginTime: window.trans('sec_user.last_login_time'),
  domain: window.trans('sec_user.domain'),
  blocking: window.trans('sec_user.blocking'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'secUser') , sorter: true },
  { title: fieldLabels.login, debugtype: 'string', dataIndex: 'login', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '23',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.pwd, debugtype: 'string_password', dataIndex: 'pwd', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.weixinOpenid, debugtype: 'string', dataIndex: 'weixinOpenid', width: '29',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.weixinAppid, debugtype: 'string', dataIndex: 'weixinAppid', width: '23',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accessToken, debugtype: 'string', dataIndex: 'accessToken', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.verificationCode, debugtype: 'int', dataIndex: 'verificationCode', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.verificationCodeExpire, dataIndex: 'verificationCodeExpire', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.lastLoginTime, dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.domain, dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.blocking, dataIndex: 'blocking', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(secUser,targetComponent)=>{

  const userContext = null
  return (
    <div key={secUser.id}>
	
      <DescriptionList  key={secUser.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{secUser.id}</Description> 
        <Description term={fieldLabels.login} style={{wordBreak: 'break-all'}}>{secUser.login}</Description> 
        <Description term={fieldLabels.mobile} style={{wordBreak: 'break-all'}}>{secUser.mobile}</Description> 
        <Description term={fieldLabels.email} style={{wordBreak: 'break-all'}}>{secUser.email}</Description> 
        <Description term={fieldLabels.pwd} style={{wordBreak: 'break-all'}}>{secUser.pwd}</Description> 
        <Description term={fieldLabels.weixinOpenid} style={{wordBreak: 'break-all'}}>{secUser.weixinOpenid}</Description> 
        <Description term={fieldLabels.weixinAppid} style={{wordBreak: 'break-all'}}>{secUser.weixinAppid}</Description> 
        <Description term={fieldLabels.accessToken} style={{wordBreak: 'break-all'}}>{secUser.accessToken}</Description> 
        <Description term={fieldLabels.verificationCode}><div style={{"color":"red"}}>{secUser.verificationCode}</div></Description> 
        <Description term={fieldLabels.verificationCodeExpire}><div>{ moment(secUser.verificationCodeExpire).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.lastLoginTime}><div>{ moment(secUser.lastLoginTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"安全用户", menuFor: "secUser",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: 'ID',
  login: '登录',
  mobile: '手机号码',
  email: '电子邮件',
  pwd: '密码',
  weixinOpenid: '微信openid',
  weixinAppid: '微信Appid',
  accessToken: '访问令牌',
  verificationCode: '验证码',
  verificationCodeExpire: '验证码过期',
  lastLoginTime: '最后登录时间',
  domain: '域',
  blocking: '屏蔽',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'secUser') , sorter: true },
  { title: fieldLabels.login, debugtype: 'string', dataIndex: 'login', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string', dataIndex: 'email', width: '23',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.pwd, debugtype: 'string_password', dataIndex: 'pwd', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.weixinOpenid, debugtype: 'string', dataIndex: 'weixinOpenid', width: '29',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.weixinAppid, debugtype: 'string', dataIndex: 'weixinAppid', width: '23',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accessToken, debugtype: 'string', dataIndex: 'accessToken', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.verificationCode, debugtype: 'int', dataIndex: 'verificationCode', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.verificationCodeExpire, dataIndex: 'verificationCodeExpire', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.lastLoginTime, dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.domain, dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.blocking, dataIndex: 'blocking', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(secUser,targetComponent)=>{

  const userContext = null
  return (
    <div key={secUser.id}>
	
      <DescriptionList  key={secUser.id} size="small" col="4">
        <Description term="ID">{secUser.id}</Description> 
        <Description term="登录">{secUser.login}</Description> 
        <Description term="手机号码">{secUser.mobile}</Description> 
        <Description term="电子邮件">{secUser.email}</Description> 
        <Description term="密码">{secUser.pwd}</Description> 
        <Description term="微信openid">{secUser.weixinOpenid}</Description> 
        <Description term="微信Appid">{secUser.weixinAppid}</Description> 
        <Description term="访问令牌">{secUser.accessToken}</Description> 
        <Description term="验证码"><div style={{"color":"red"}}>{secUser.verificationCode}</div></Description> 
        <Description term="验证码过期"><div>{ moment(secUser.verificationCodeExpire).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="最后登录时间"><div>{ moment(secUser.lastLoginTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="当前状态">{secUser.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId} = formValuesToPack
	const domain = {id: domainId, version: 2^31}
	const data = {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domain}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domain} = objectToUnpack
	const domainId = domain ? domain.id : null
	const data = {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId}
	return data
}

const SecUserBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId, blockingId} = formValuesToPack
	const domain = {id: domainId, version: 2^31}
	const blocking = {id: blockingId, version: 2^31}
	const data = {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domain, blocking}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domain, blocking} = objectToUnpack
	const domainId = domain ? domain.id : null
	const blockingId = blocking ? blocking.id : null
	const data = {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId, blockingId}
	return data
}
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
const SecUserBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default SecUserBase



