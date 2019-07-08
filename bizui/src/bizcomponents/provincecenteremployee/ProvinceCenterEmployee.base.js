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


const menuData = {menuName:"Province Center Employee", menuFor: "provinceCenterEmployee",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  mobile: 'Mobile',
  email: 'Email',
  founded: 'Founded',
  department: 'Department',
  provinceCenter: 'Province Center',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.provinceCenter, dataIndex: 'provinceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(provinceCenterEmployee,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={provinceCenterEmployee.id}>
	
	<DescriptionList  key={provinceCenterEmployee.id} size="small" col="4">
<Description term="Id">{provinceCenterEmployee.id}</Description> 
<Description term="Name">{provinceCenterEmployee.name}</Description> 
<Description term="Mobile">{provinceCenterEmployee.mobile}</Description> 
<Description term="Email">{provinceCenterEmployee.email}</Description> 
<Description term="Founded">{ moment(provinceCenterEmployee.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Department">{provinceCenterEmployee.department==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.department.displayName}(${provinceCenterEmployee.department.id})`}
</Description>
<Description term="Province Center">{provinceCenterEmployee.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.provinceCenter.displayName}(${provinceCenterEmployee.provinceCenter.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ProvinceCenterEmployeeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ProvinceCenterEmployeeBase



