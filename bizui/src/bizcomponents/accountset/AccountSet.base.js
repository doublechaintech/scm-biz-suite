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
import styles from './AccountSet.base.less'
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




const menuData = {menuName: window.trans('account_set'), menuFor: "accountSet",  internalName: "account_set",
  		subItems: [
  {name: 'accountingSubjectList', displayName: window.mtrans('accounting_subject','account_set.accounting_subject_list',false), type:'accountingSubject',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingPeriodList', displayName: window.mtrans('accounting_period','account_set.accounting_period_list',false), type:'accountingPeriod',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingDocumentTypeList', displayName: window.mtrans('accounting_document_type','account_set.accounting_document_type_list',false), type:'accountingDocumentType',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},

  		],
}


const settingMenuData = {menuName: window.trans('account_set'), menuFor: "accountSet",  internalName: "account_set",
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
  id: window.trans('account_set.id'),
  name: window.trans('account_set.name'),
  yearSet: window.trans('account_set.year_set'),
  effectiveDate: window.trans('account_set.effective_date'),
  accountingSystem: window.trans('account_set.accounting_system'),
  domesticCurrencyCode: window.trans('account_set.domestic_currency_code'),
  domesticCurrencyName: window.trans('account_set.domestic_currency_name'),
  openingBank: window.trans('account_set.opening_bank'),
  accountNumber: window.trans('account_set.account_number'),
  countryCenter: window.trans('account_set.country_center'),
  retailStore: window.trans('account_set.retail_store'),
  goodsSupplier: window.trans('account_set.goods_supplier'),
  lastUpdateTime: window.trans('account_set.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'accountSet') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.yearSet, debugtype: 'string', dataIndex: 'yearSet', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.effectiveDate, dataIndex: 'effectiveDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.accountingSystem, debugtype: 'string', dataIndex: 'accountingSystem', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domesticCurrencyCode, debugtype: 'string', dataIndex: 'domesticCurrencyCode', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domesticCurrencyName, debugtype: 'string', dataIndex: 'domesticCurrencyName', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.openingBank, debugtype: 'string', dataIndex: 'openingBank', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountNumber, debugtype: 'string', dataIndex: 'accountNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countryCenter, dataIndex: 'countryCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.retailStore, dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.goodsSupplier, dataIndex: 'goodsSupplier', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

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


const renderActionList=(accountSet, targetObject, columCount, listName)=>{

	if(!accountSet){
		return null
	}
	if(!accountSet.actionList){
		return null
	}
	if(accountSet.actionList.length === 0){
		return null
	}
	return (
		<div className={styles.overlay}>

			<div className={styles.overlayContent}>
			{accountSet.actionList.map(action=>(<Link key={action.id} to={{pathname: action.actionPath.substring(1), state: {ownerId:targetObject.id,action,selectedRows:[accountSet]}}} >
				<span className={styles.overlayText}>{action.actionName}</span>
				</Link> ))}
			</div>

		</div>
		)

}

const renderItemOfList=(accountSet, targetObject, columCount, listName)=>{

  if(!accountSet){
  	return null
  }
  if(!accountSet.id){
  	return null
  }


  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
     <Row key={`${listName}-${accountSet.id}`} className={styles.itemDesc}>

	<Col span={4}>
		<Avatar size={90} className={styles.avarta} style={{ backgroundColor: genColor()}}>
			{leftChars(accountSet.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  



      <DescriptionList  key={accountSet.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountSet.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{accountSet.name}</Description> 
        <Description term={fieldLabels.yearSet} style={{wordBreak: 'break-all'}}>{accountSet.yearSet}</Description> 
        <Description term={fieldLabels.effectiveDate}><div>{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.accountingSystem} style={{wordBreak: 'break-all'}}>{accountSet.accountingSystem}</Description> 
        <Description term={fieldLabels.domesticCurrencyCode} style={{wordBreak: 'break-all'}}>{accountSet.domesticCurrencyCode}</Description> 
        <Description term={fieldLabels.domesticCurrencyName} style={{wordBreak: 'break-all'}}>{accountSet.domesticCurrencyName}</Description> 
        <Description term={fieldLabels.openingBank} style={{wordBreak: 'break-all'}}>{accountSet.openingBank}</Description> 
        <Description term={fieldLabels.accountNumber} style={{wordBreak: 'break-all'}}>{accountSet.accountNumber}</Description> 
        <Description term={fieldLabels.retailStore}>{renderReferenceItem(accountSet.retailStore)}</Description>

        <Description term={fieldLabels.goodsSupplier}>{renderReferenceItem(accountSet.goodsSupplier)}</Description>

        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 


      </DescriptionList>
     </Col>
      {renderActionList(accountSet,targetObject)}
    </Row>
	)

}

const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId, goodsSupplierId, lastUpdateTime} = formValuesToPack
	const countryCenter = {id: countryCenterId, version: 2^31}
	const retailStore = {id: retailStoreId, version: 2^31}
	const goodsSupplier = {id: goodsSupplierId, version: 2^31}
	const data = {name, yearSet, effectiveDate:moment(effectiveDate).valueOf(), accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenter, retailStore, goodsSupplier, lastUpdateTime:moment(lastUpdateTime).valueOf()}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenter, retailStore, goodsSupplier, lastUpdateTime} = objectToUnpack
	const countryCenterId = countryCenter ? countryCenter.id : null
	const retailStoreId = retailStore ? retailStore.id : null
	const goodsSupplierId = goodsSupplier ? goodsSupplier.id : null
	const data = {name, yearSet, effectiveDate:moment(effectiveDate), accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId, goodsSupplierId, lastUpdateTime:moment(lastUpdateTime)}
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



const AccountSetBase={unpackObjectToFormValues, menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default AccountSetBase

