import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"安全用户", menuFor: "secUser",
  		subItems: [
  {name: 'userAppList', displayName:'用户应用程序', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'loginHistoryList', displayName:'登录历史', icon:'history',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

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
	



const SecUserBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SecUserBase



