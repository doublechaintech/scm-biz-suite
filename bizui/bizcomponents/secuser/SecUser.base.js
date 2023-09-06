import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Row, Tag, Button,Table} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './SecUser.base.less'
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
	defaultRenderNumberCell,
	defaultFormatNumber,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell
const renderNumberCell=defaultRenderNumberCell
const formatNumber = defaultFormatNumber

const renderImageListCell=(imageList, record)=>{
	const userContext = null;
	if(!imageList){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(imageList.length === 0){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return (<span>{
		imageList.map(item=>(<img width="40px" key={item.id} title={item.title} src={item.imageUrl}/>))
		}</span>)
}




const menuData = {menuName: window.trans('sec_user'), menuFor: "secUser",  internalName: "sec_user",
  		subItems: [
  {name: 'userAppList', displayName: window.mtrans('user_app','sec_user.user_app_list',false), type:'userApp',icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'loginHistoryList', displayName: window.mtrans('login_history','sec_user.login_history_list',false), type:'loginHistory',icon:'history',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'wechatWorkappIdentityList', displayName: window.mtrans('wechat_workapp_identity','sec_user.wechat_workapp_identity_list',false), type:'wechatWorkappIdentity',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'wechatMiniappIdentityList', displayName: window.mtrans('wechat_miniapp_identity','sec_user.wechat_miniapp_identity_list',false), type:'wechatMiniappIdentity',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'keyPairIdentityList', displayName: window.mtrans('key_pair_identity','sec_user.key_pair_identity_list',false), type:'keyPairIdentity',icon:'key',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},

  		],
}


const settingMenuData = {menuName: window.trans('sec_user'), menuFor: "secUser",  internalName: "sec_user",
  		subItems: [

  		],
}


const mergedSubItems=()=>{

    const result = []
    menuData.subItems.forEach(item=>{
        result.push({...item, for: "menu"})
    })
    settingMenuData.subItems.forEach(item=>{
        result.push({...item, for: "setting"})
    })
    return result
}
const universalMenuData = {...menuData, subItems: mergedSubItems()}



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

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'secUser') , sorter: true },
  { title: fieldLabels.login, debugtype: 'string', dataIndex: 'login', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '23',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.pwd, debugtype: 'string_password', dataIndex: 'pwd', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.weixinOpenid, debugtype: 'string', dataIndex: 'weixinOpenid', width: '29',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.weixinAppid, debugtype: 'string', dataIndex: 'weixinAppid', width: '23',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accessToken, debugtype: 'string', dataIndex: 'accessToken', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.verificationCode, dataIndex: 'verificationCode', className:'money', render: (text, record) => renderNumberCell(text, record, 0), sorter: true  },
  { title: fieldLabels.verificationCodeExpire, dataIndex: 'verificationCodeExpire', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.lastLoginTime, dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.domain, dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(universalMenuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderTextItem=(value, label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}
const renderImageItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}

	return <ImagePreview title={label} imageLocation={value}/>
}

const renderDateItem=(value, label,targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return moment(value).format('YYYY-MM-DD');
}

const renderDateTimeItem=(value,label, targetComponent)=>{
	const userContext = window.userContext
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return  moment(value).format('YYYY-MM-DD HH:mm')
}


const renderReferenceItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}


const renderImageList=(imageList,label, targetComponent)=>{
	const userContext = null
	if(!imageList){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(imageList.length === 0){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	// return JSON.stringify(imageList)
/*
	the data looks like this
	{"id":"1601","title":"cover_images01",
	"imageUrl":"https://demo.doublechaintech.com/demodata/imageManager/genImage/cover_images010016/400/200/grey/"},
	{"id":"1602","title":"cover_images02",
	"imageUrl":"https://demo.doublechaintech.com/demodata/imageManager/genImage/cover_images020016/400/200/grey/"}
*/
	return (<span>{
		imageList.map(item=>(<img width="40px" key={item.id} title={item.title} src={item.imageUrl}/>))
		}</span>)

}


const renderActionList=(secUser, targetObject, columCount, listName)=>{

	if(!secUser){
		return null
	}
	if(!secUser.actionList){
		return null
	}
	if(secUser.actionList.length === 0){
		return null
	}
	return (
		<div className={styles.overlay}>

			<div className={styles.overlayContent}>
			{secUser.actionList.map(action=>(<Link key={action.id} to={{pathname: action.actionPath.substring(1), state: {ownerId:targetObject.id,action,selectedRows:[secUser]}}} >
				<span className={styles.overlayText}>{action.actionName}</span>
				</Link> ))}
			</div>

		</div>
		)

}

const renderItemOfList=(secUser, targetObject, columCount, listName)=>{

  if(!secUser){
  	return null
  }
  if(!secUser.id){
  	return null
  }


  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
     <Row key={`${listName}-${secUser.id}`} className={styles.itemDesc}>

	<Col span={4}>
		<Avatar size={90} className={styles.avarta} style={{ backgroundColor: genColor()}}>
			{leftChars(secUser.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  



      <DescriptionList  key={secUser.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{secUser.id}</Description> 
        <Description term={fieldLabels.login} style={{wordBreak: 'break-all'}}>{secUser.login}</Description> 
        <Description term={fieldLabels.mobile} style={{wordBreak: 'break-all'}}>{secUser.mobile}</Description> 
        <Description term={fieldLabels.email} style={{wordBreak: 'break-all'}}>{secUser.email}</Description> 
        <Description term={fieldLabels.pwd} style={{wordBreak: 'break-all'}}>{secUser.pwd}</Description> 
        <Description term={fieldLabels.weixinOpenid} style={{wordBreak: 'break-all'}}>{secUser.weixinOpenid}</Description> 
        <Description term={fieldLabels.weixinAppid} style={{wordBreak: 'break-all'}}>{secUser.weixinAppid}</Description> 
        <Description term={fieldLabels.accessToken} style={{wordBreak: 'break-all'}}>{secUser.accessToken}</Description> 
        <Description term={fieldLabels.verificationCode}><div style={{"color":"red"}}>{formatNumber(secUser.verificationCode,0)}</div></Description> 
        <Description term={fieldLabels.verificationCodeExpire}><div>{ moment(secUser.verificationCodeExpire).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.lastLoginTime}><div>{ moment(secUser.lastLoginTime).format('YYYY-MM-DD HH:mm')}</div></Description> 


      </DescriptionList>
     </Col>
      {renderActionList(secUser,targetObject)}
    </Row>
	)

}

const packFormValuesToObject = ( formValuesToPack )=>{
	const {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId} = formValuesToPack
	const domain = {id: domainId, version: 2^31}
	const data = {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire:moment(verificationCodeExpire).valueOf(), lastLoginTime:moment(lastLoginTime).valueOf(), domain}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domain} = objectToUnpack
	const domainId = domain ? domain.id : null
	const data = {login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire:moment(verificationCodeExpire), lastLoginTime:moment(lastLoginTime), domainId}
	return data
}


const stepOf=(targetComponent, title, content, position, index, initValue)=>{
	const isMultipleEvent=false
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
		initValue,
		isMultipleEvent,
      }
}



const SecUserBase={unpackObjectToFormValues, menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SecUserBase

