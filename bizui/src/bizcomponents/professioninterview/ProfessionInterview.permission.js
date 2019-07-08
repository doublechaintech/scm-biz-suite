

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
import styles from './ProfessionInterview.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (professionInterview,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{professionInterview.id}</Description> 
<Description term="Who">{professionInterview.who}</Description> 
<Description term="Interview Time">{ moment(professionInterview.interviewTime).format('YYYY-MM-DD')}</Description> 
<Description term="Comments">{professionInterview.comments}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = professionInterview => {
  const {ProfessionInterviewBase} = GlobalComponents
  return <PermissionSetting targetObject={professionInterview}  targetObjectMeta={ProfessionInterviewBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ProfessionInterviewPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  professionInterview = this.props.professionInterview;
    const { id,displayName, employeeCount } = professionInterview
    const cardsData = {cardsName:"Profession Interview",cardsFor: "professionInterview",cardsSource: professionInterview,
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
  professionInterview: state._professionInterview,
}))(Form.create()(ProfessionInterviewPermission))

