

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './FormField.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (formField,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{formField.id}</Description> 
<Description term="标签">{formField.label}</Description> 
<Description term="语言环境的关键">{formField.localeKey}</Description> 
<Description term="参数名称">{formField.parameterName}</Description> 
<Description term="类型">{formField.type}</Description> 
<Description term="占位符">{formField.placeholder}</Description> 
<Description term="默认值">{formField.defaultValue}</Description> 
<Description term="描述">{formField.description}</Description> 
<Description term="字段组">{formField.fieldGroup}</Description> 
<Description term="最小值">{formField.minimumValue}</Description> 
<Description term="最大值">{formField.maximumValue}</Description> 
<Description term="候选人的价值观">{formField.candidateValues}</Description> 
<Description term="建议值">{formField.suggestValues}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = formField => {
  const {FormFieldBase} = GlobalComponents
  return <PermissionSetting targetObject={formField}  targetObjectMeta={FormFieldBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class FormFieldPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  formField = this.props.formField
    const { id,displayName,  } = formField
    const  returnURL = `/formField/${id}/dashboard`
    const cardsData = {cardsName:"表单字段",cardsFor: "formField",cardsSource: formField,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  formField: state._formField,
}))(Form.create()(FormFieldPermission))

