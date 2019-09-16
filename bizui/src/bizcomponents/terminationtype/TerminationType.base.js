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


const menuData = {menuName:"雇佣终止类型", menuFor: "terminationType",
  		subItems: [
  {name: 'terminationList', displayName:'雇佣终止', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"雇佣终止类型", menuFor: "terminationType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  code: '代码',
  company: '公司',
  baseDescription: '基本描述',
  detailDescription: '详细描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'terminationType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.baseDescription, debugtype: 'string', dataIndex: 'baseDescription', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.detailDescription, debugtype: 'string', dataIndex: 'detailDescription', width: '66',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(terminationType,targetComponent)=>{

  const userContext = null
  return (
    <div key={terminationType.id}>
	
      <DescriptionList  key={terminationType.id} size="small" col="4">
        <Description term="序号">{terminationType.id}</Description> 
        <Description term="代码">{terminationType.code}</Description> 
        <Description term="基本描述">{terminationType.baseDescription}</Description> 
        <Description term="详细描述">{terminationType.detailDescription}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const TerminationTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TerminationTypeBase



