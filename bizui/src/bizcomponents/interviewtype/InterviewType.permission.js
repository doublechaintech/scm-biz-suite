

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './InterviewType.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (interviewType,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{interviewType.id}</Description> 
<Description term="Code">{interviewType.code}</Description> 
<Description term="Description">{interviewType.description}</Description> 
<Description term="Detail Description">{interviewType.detailDescription}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = interviewType => {
  const {InterviewTypeBase} = GlobalComponents
  return <PermissionSetting targetObject={interviewType}  targetObjectMeta={InterviewTypeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class InterviewTypePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  interviewType = this.props.interviewType;
    const { id,displayName, employeeInterviewCount } = interviewType
    const cardsData = {cardsName:"Interview Type",cardsFor: "interviewType",cardsSource: interviewType,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
  interviewType: state._interviewType,
}))(Form.create()(InterviewTypePermission))

