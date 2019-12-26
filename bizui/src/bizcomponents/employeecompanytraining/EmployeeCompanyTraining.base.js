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
const menuData = {menuName:"员工参与的公司培训", menuFor: "employeeCompanyTraining",
=======

const menuData = {menuName: window.trans('employee_company_training'), menuFor: "employeeCompanyTraining",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('employee_company_training'), menuFor: "employeeCompanyTraining",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_company_training.id'),
  employee: window.trans('employee_company_training.employee'),
  training: window.trans('employee_company_training.training'),
  scoring: window.trans('employee_company_training.scoring'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeCompanyTraining') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.training, dataIndex: 'training', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.scoring, dataIndex: 'scoring', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeCompanyTraining,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeCompanyTraining.id}>
	
      <DescriptionList  key={employeeCompanyTraining.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeCompanyTraining.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeCompanyTraining.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.employee.displayName}(${employeeCompanyTraining.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.training}><div>{employeeCompanyTraining.training==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.training.displayName}(${employeeCompanyTraining.training.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"员工参与的公司培训", menuFor: "employeeCompanyTraining",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  employee: '员工',
  training: '训练',
  scoring: '评分',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeCompanyTraining') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.training, dataIndex: 'training', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.scoring, dataIndex: 'scoring', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '10',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeCompanyTraining,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeCompanyTraining.id}>
	
      <DescriptionList  key={employeeCompanyTraining.id} size="small" col="4">
        <Description term="序号">{employeeCompanyTraining.id}</Description> 
        <Description term="员工"><div>{employeeCompanyTraining.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.employee.displayName}(${employeeCompanyTraining.employee.id})`}
        </div></Description>
        <Description term="训练"><div>{employeeCompanyTraining.training==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.training.displayName}(${employeeCompanyTraining.training.id})`}
        </div></Description>
        <Description term="当前状态">{employeeCompanyTraining.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {employeeId, trainingId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const training = {id: trainingId, version: 2^31}
	const data = {employee, training}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {employee, training} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const trainingId = training ? training.id : null
	const data = {employeeId, trainingId}
	return data
}

const EmployeeCompanyTrainingBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {employeeId, trainingId, scoringId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const training = {id: trainingId, version: 2^31}
	const scoring = {id: scoringId, version: 2^31}
	const data = {employee, training, scoring}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {employee, training, scoring} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const trainingId = training ? training.id : null
	const scoringId = scoring ? scoring.id : null
	const data = {employeeId, trainingId, scoringId}
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
const EmployeeCompanyTrainingBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeCompanyTrainingBase



