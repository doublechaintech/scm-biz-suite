import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './EmployeeSalarySheet.base.less'
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



const menuData = {menuName: window.trans('employee_salary_sheet'), menuFor: "employeeSalarySheet",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_salary_sheet'), menuFor: "employeeSalarySheet",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_salary_sheet.id'),
  employee: window.trans('employee_salary_sheet.employee'),
  currentSalaryGrade: window.trans('employee_salary_sheet.current_salary_grade'),
  baseSalary: window.trans('employee_salary_sheet.base_salary'),
  bonus: window.trans('employee_salary_sheet.bonus'),
  reward: window.trans('employee_salary_sheet.reward'),
  personalTax: window.trans('employee_salary_sheet.personal_tax'),
  socialSecurity: window.trans('employee_salary_sheet.social_security'),
  housingFound: window.trans('employee_salary_sheet.housing_found'),
  jobInsurance: window.trans('employee_salary_sheet.job_insurance'),
  payingOff: window.trans('employee_salary_sheet.paying_off'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeSalarySheet') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentSalaryGrade, dataIndex: 'currentSalaryGrade', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.baseSalary, dataIndex: 'baseSalary', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.bonus, dataIndex: 'bonus', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.reward, dataIndex: 'reward', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.personalTax, dataIndex: 'personalTax', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.socialSecurity, dataIndex: 'socialSecurity', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.housingFound, dataIndex: 'housingFound', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.jobInsurance, dataIndex: 'jobInsurance', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.payingOff, dataIndex: 'payingOff', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(employeeSalarySheet, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(employeeSalarySheet, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={employeeSalarySheet.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(employeeSalarySheet.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={employeeSalarySheet.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeSalarySheet.id}</Description> 
        <Description term={fieldLabels.employee}><Tag color='blue' title={`${employeeSalarySheet.employee.id}-${employeeSalarySheet.employee.displayName}`}>{employeeSalarySheet.employee==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(employeeSalarySheet.employee.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.currentSalaryGrade}><Tag color='blue' title={`${employeeSalarySheet.currentSalaryGrade.id}-${employeeSalarySheet.currentSalaryGrade.displayName}`}>{employeeSalarySheet.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(employeeSalarySheet.currentSalaryGrade.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.baseSalary}><div style={{"color":"red"}}>{employeeSalarySheet.baseSalary}</div></Description> 
        <Description term={fieldLabels.bonus}><div style={{"color":"red"}}>{employeeSalarySheet.bonus}</div></Description> 
        <Description term={fieldLabels.reward}><div style={{"color":"red"}}>{employeeSalarySheet.reward}</div></Description> 
        <Description term={fieldLabels.personalTax}><div style={{"color":"red"}}>{employeeSalarySheet.personalTax}</div></Description> 
        <Description term={fieldLabels.socialSecurity}><div style={{"color":"red"}}>{employeeSalarySheet.socialSecurity}</div></Description> 
        <Description term={fieldLabels.housingFound}><div style={{"color":"red"}}>{employeeSalarySheet.housingFound}</div></Description> 
        <Description term={fieldLabels.jobInsurance}><div style={{"color":"red"}}>{employeeSalarySheet.jobInsurance}</div></Description> 
        <Description term={fieldLabels.payingOff}><Tag color='blue' title={`${employeeSalarySheet.payingOff.id}-${employeeSalarySheet.payingOff.displayName}`}>{employeeSalarySheet.payingOff==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(employeeSalarySheet.payingOff.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employeeId, currentSalaryGradeId, payingOffId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const currentSalaryGrade = {id: currentSalaryGradeId, version: 2^31}
	const payingOff = {id: payingOffId, version: 2^31}
	const data = {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employee, currentSalaryGrade, payingOff}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employee, currentSalaryGrade, payingOff} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const currentSalaryGradeId = currentSalaryGrade ? currentSalaryGrade.id : null
	const payingOffId = payingOff ? payingOff.id : null
	const data = {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employeeId, currentSalaryGradeId, payingOffId}
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
const EmployeeSalarySheetBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeSalarySheetBase

