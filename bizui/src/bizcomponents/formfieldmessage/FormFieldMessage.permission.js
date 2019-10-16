

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './FormFieldMessage.profile.less'
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
const internalSummaryOf = (formFieldMessage,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{formFieldMessage.id}</Description> 
<Description term="标题">{formFieldMessage.title}</Description> 
<Description term="参数名称">{formFieldMessage.parameterName}</Description> 
<Description term="水平">{formFieldMessage.level}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = formFieldMessage => {
  const {FormFieldMessageBase} = GlobalComponents
  return <PermissionSetting targetObject={formFieldMessage}  targetObjectMeta={FormFieldMessageBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class FormFieldMessagePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  formFieldMessage = this.props.formFieldMessage
    const { id,displayName,  } = formFieldMessage
    const  returnURL = `/formFieldMessage/${id}/dashboard`
    const cardsData = {cardsName:"表单字段的信息",cardsFor: "formFieldMessage",cardsSource: formFieldMessage,displayName,returnURL,
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
  formFieldMessage: state._formFieldMessage,
}))(Form.create()(FormFieldMessagePermission))

