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
const menuData = {menuName:"工资支付", menuFor: "payingOff",
  		subItems: [
  {name: 'employeeSalarySheetList', displayName:'工资单', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('paying_off'), menuFor: "payingOff",
  		subItems: [
  {name: 'employeeSalarySheetList', displayName: window.mtrans('employee_salary_sheet','paying_off.employee_salary_sheet_list',false), type:'employeeSalarySheet',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('paying_off'), menuFor: "payingOff",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('paying_off.id'),
  who: window.trans('paying_off.who'),
  paidFor: window.trans('paying_off.paid_for'),
  paidTime: window.trans('paying_off.paid_time'),
  amount: window.trans('paying_off.amount'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'payingOff') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.paidFor, dataIndex: 'paidFor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.paidTime, dataIndex: 'paidTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(payingOff,targetComponent)=>{

  const userContext = null
  return (
    <div key={payingOff.id}>
	
      <DescriptionList  key={payingOff.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{payingOff.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{payingOff.who}</Description> 
        <Description term={fieldLabels.paidFor}><div>{payingOff.paidFor==null?appLocaleName(userContext,"NotAssigned"):`${payingOff.paidFor.displayName}(${payingOff.paidFor.id})`}
        </div></Description>
        <Description term={fieldLabels.paidTime}><div>{ moment(payingOff.paidTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{payingOff.amount}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"工资支付", menuFor: "payingOff",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  who: '谁',
  paidFor: '支付',
  paidTime: '支付时间',
  amount: '金额',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'payingOff') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.paidFor, dataIndex: 'paidFor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.paidTime, dataIndex: 'paidTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(payingOff,targetComponent)=>{

  const userContext = null
  return (
    <div key={payingOff.id}>
	
      <DescriptionList  key={payingOff.id} size="small" col="4">
        <Description term="序号">{payingOff.id}</Description> 
        <Description term="谁">{payingOff.who}</Description> 
        <Description term="支付"><div>{payingOff.paidFor==null?appLocaleName(userContext,"NotAssigned"):`${payingOff.paidFor.displayName}(${payingOff.paidFor.id})`}
        </div></Description>
        <Description term="支付时间"><div>{ moment(payingOff.paidTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="金额"><div style={{"color":"red"}}>{payingOff.amount}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, paidTime, amount, paidForId} = formValuesToPack
	const paidFor = {id: paidForId, version: 2^31}
	const data = {who, paidTime, amount, paidFor}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, paidTime, amount, paidForId} = formValuesToPack
	const paidFor = {id: paidForId, version: 2^31}
	const data = {who, paidTime, amount, paidFor}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, paidTime, amount, paidFor} = objectToUnpack
	const paidForId = paidFor ? paidFor.id : null
	const data = {who, paidTime, amount, paidForId}
	return data
}
<<<<<<< HEAD

const PayingOffBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const PayingOffBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default PayingOffBase



